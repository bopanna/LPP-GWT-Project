package com.hp.api.test.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Page3 extends Composite {
    private VerticalPanel page3 = new VerticalPanel();
    final Button sendButton = new Button("Send");
    private TabPanel tabPanel = new TabPanel();
    static private Page3 _instance = null;
    
    public Page3() throws RequestException{
        initPage();
        initWidget(page3);
    }

    public static Page3 getInstance() throws RequestException{
        if(null == _instance) {
            _instance = new Page3();
        }
        return _instance;
    }

    private void initPage() throws RequestException {
    	page3.setWidth("100%");
    	page3.setHeight("100%");
    	
    	// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		
		final HTML serverResponseLabel = new HTML();
		
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>API Response:</b>"));
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		dialogBox.setHeight("4000");
		dialogBox.setWidth("4000");
		
		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});
		
		serverResponseLabel.setText("");
    	
    	// We can add style names to widgets
    	sendButton.addStyleName("sendButton");
    	
    	VerticalPanel panel = new VerticalPanel();
    	
        // Create a ListBox, giving it a name and 
        // some values to be associated with its options.
        HorizontalPanel triggerType = new HorizontalPanel();
    	Label tr = new Label("Trigger Type");
        final ListBox lb = new ListBox();
        lb.addItem("watermark", "watermark");
        lb.addItem("shorturl", "shorturl");
        lb.addItem("qrcode", "qrcode");
        lb.setWidth("220");
        triggerType.add(tr);
        triggerType.add(lb);
        triggerType.setSpacing(4);
        
    	
        HorizontalPanel hpDis = new HorizontalPanel();
    	Label disLabel = new Label("Name");
        final TextBox tb = new TextBox();
        tb.setName("textBoxFormElement");
        hpDis.add(disLabel);
        hpDis.add(tb);
        hpDis.setSpacing(4);
        
        HorizontalPanel authorizationPanel = new HorizontalPanel();
    	Label authName = new Label("Auth Token");
        final TextBox tb2 = new TextBox();
        tb2.setName("textBoxFormElement");
        authorizationPanel.add(authName);
        authorizationPanel.add(tb2);
        authorizationPanel.setSpacing(4);
        
        
        
/*        ListBox lb3 = new ListBox();
        lb3.setName("typefriendly");
        lb3.addItem("true", "true");
        lb3.addItem("false", "false");
        lb3.setWidth("220");*/
        
        panel.add(hpDis);
        panel.add(triggerType);
        panel.add(authorizationPanel);
        panel.setWidth("100%");
        panel.setHeight("100%");
        
   
        
        
    	

        //create contents for tabs of tabpanel
/*        Label label1 = new Label("Create Triggers");
        label1.setHeight("100%");*/
        Label label2 = new Label("This is contents of TAB 2");
        label2.setHeight("100%");
        Label label3 = new Label("This is contents of TAB 3");
        label3.setHeight("100%");

        //create titles for tabs
        String tab1Title = "Create Triggers";
        String tab2Title = "TAB 2";
        String tab3Title = "TAB 3";

        //create tabs 
        tabPanel.add(panel, tab1Title);
        tabPanel.add(label2, tab2Title);
        tabPanel.add(label3, tab3Title);
        tabPanel.selectTab(0);
        tabPanel.setSize("100%", "100%");
        
        
        

        //select first tab
        page3.add(tabPanel);
        
     // Create a handler for the sendButton and nameField
     		class MyHandler implements ClickHandler, KeyUpHandler {
     			/**
     			 * Fired when the user clicks on the sendButton.
     			 */
     			public void onClick(ClickEvent event) {
     				try {
						sendNameToServer();
					} catch (RequestException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
     			}

     			/**
     			 * Fired when the user types in the nameField.
     			 */
     			public void onKeyUp(KeyUpEvent event) {
     				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
     					try {
							sendNameToServer();
						} catch (RequestException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
     				}
     			}

     			/**
     			 * Send the name from the nameField to the server and wait for a response.
     			 * @throws RequestException 
     			 */
     			private void sendNameToServer() throws RequestException {
     				
     			   String authToken = tb2.getText();
     			   String triggerName = tb.getText();
     			   int triggerTypeIndex = lb.getSelectedIndex();
     			   String triggerType = lb.getItemText(triggerTypeIndex);
     				
     		       RequestBuilder builder = new RequestBuilder(RequestBuilder.POST /*.POST or .PUT or .DELETE*/, "https://dev.livepaperapi.com/api/v1/triggers");
     		        builder.setHeader("content-type", "application/json"); /*or any other type that you're expecting*/
     		        builder.setHeader("Authorization", "Bearer " + authToken);
     		        
     		        Request response = builder.sendRequest("{\"trigger\":{\"name\": \""+ triggerName + "\",\"type\": \""+ triggerType +"\"}}", new RequestCallback() {
     		        	 @Override
     		        	 public void onResponseReceived(Request request, Response response) {
     		        	  int statusCode = response.getStatusCode();
     		        	  
     		        	  if(statusCode == Response.SC_CREATED) {
/*     		        		  Label responseLabel2 = new Label(response.getText());
     		        	      page3.add(responseLabel2);*/
     		        	   String responseBody = response.getText();
     		        	  dialogBox.setText("Remote Procedure Call");
							serverResponseLabel
									.removeStyleName("serverResponseLabelError");
							serverResponseLabel.setHTML(response.getText());
							dialogBox.center();
							closeButton.setFocus(true);
     		        	   //do something with the response
     		        	  } else {
     		        	   //do in case of server error
     		        	  }
     		        	 }

     		        	 @Override
     		        	 public void onError(Request request, Throwable exception) {
     		        		 Label responseLabel = new Label(exception.getMessage());
     		       	      page3.add(responseLabel);
     		        	  //error actually sending the request, never got sent
     		        	 }
     		        	});
     			}
     		}
     		
    		// Add a handler to send the name to the server
    		MyHandler handler = new MyHandler();
    		sendButton.addClickHandler(handler);
    		
    		page3.add(sendButton);

        
    }
}