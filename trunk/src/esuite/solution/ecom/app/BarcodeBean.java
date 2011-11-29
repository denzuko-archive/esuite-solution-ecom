package esuite.solution.ecom.app;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.google.gson.Gson;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

@ManagedBean
@RequestScoped
@URLMapping(id = "barcode", viewId = "/empty.jsf", 
    pattern = "/barcode/#{ /[0-9]+/ barcodeBean.value }.png")
public class BarcodeBean implements BarcodeBeanProxy {

	private String value;
	
	public BarcodeBean() {
		
	}
	 
	  @URLAction
	  public void render() throws IOException {
	 
	    // get HttpServletResponse
	    FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletResponse response = 
	      (HttpServletResponse) context.getExternalContext().getResponse();
	 
	    // set correct content type
	    response.setContentType("image/png");
	 
	    // setup CanvasProvider to render bitmap to response stream
	    BitmapCanvasProvider canvas = new BitmapCanvasProvider(
	        response.getOutputStream(), "image/png", 150,
	        BufferedImage.TYPE_BYTE_BINARY, false, 0);
	 
	    Gson gson = new Gson();
	    // render barcode
	    Interleaved2Of5Bean barcode = new Interleaved2Of5Bean();
	    barcode.generateBarcode(canvas, value);
	    canvas.finish();
	 
	    // mark response as completed
	    context.responseComplete();
	 
	  }

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	 
}
