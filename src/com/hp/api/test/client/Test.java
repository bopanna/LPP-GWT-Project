package com.hp.api.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Test extends Composite implements EntryPoint {
	private static final String LOGIN_TOKEN = "login";

	private static TestUiBinder uiBinder = GWT.create(TestUiBinder.class);

	interface TestUiBinder extends UiBinder<SplitLayoutPanel, Test> {
	}

	@UiField
	public static StackPanel token, links, triggers, payoffs, fileUpload,
			fileDownload, analytics;

	@UiField
	public static VerticalPanel formPanel;
	
	
	SplitLayoutPanel outer = uiBinder.createAndBindUi(this);

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		  RootLayoutPanel.get().add(outer);
		  formPanel.setHeight("100%");
		  formPanel.setWidth("100%");
	      
	      token.add(new Label("Token"));
	      
	      token.addHandler(new ClickHandler()
	      {
	    	    @Override
	    	    public void onClick(ClickEvent clickEvent)
	    	    {
	    	    	loadTokenPage();
	    	    }
	    	}, ClickEvent.getType());
	      
	      links.add(new Label("Links"));
	      
	      links.addHandler(new ClickHandler()
	      {
	    	    @Override
	    	    public void onClick(ClickEvent clickEvent)
	    	    {
	    	    	loadLinksPage();
	    	    }
	    	}, ClickEvent.getType());
	      
	      triggers.add(new Label("Triggers"));
	      
	      triggers.addHandler(new ClickHandler()
	      {
	    	    @Override
	    	    public void onClick(ClickEvent clickEvent)
	    	    {
	    	    	loadTriggersPage();
	    	    }
	    	}, ClickEvent.getType());
	      
	      payoffs.add(new Label("Payoffs"));
	      
	      payoffs.addHandler(new ClickHandler()
	      {
	    	    @Override
	    	    public void onClick(ClickEvent clickEvent)
	    	    {
	    	    	loadPayoffsPage();
	    	    }
	    	}, ClickEvent.getType());
	      
	      fileUpload.add(new Label("File Upload"));
	      
	      fileUpload.addHandler(new ClickHandler()
	      {
	    	    @Override
	    	    public void onClick(ClickEvent clickEvent)
	    	    {
	    	    	loadFileUploadPage();
	    	    }
	    	}, ClickEvent.getType());
	      
	      fileDownload.add(new Label("File Download"));
	      
	      fileDownload.addHandler(new ClickHandler()
	      {
	    	    @Override
	    	    public void onClick(ClickEvent clickEvent)
	    	    {
	    	    	loadFileDownloadPage();
	    	    }
	    	}, ClickEvent.getType());

	      analytics.add(new Label("Analytics"));
	      
	      analytics.addHandler(new ClickHandler()
	      {
	    	    @Override
	    	    public void onClick(ClickEvent clickEvent)
	    	    {
	    	    	loadAnalyticsPage();
	    	    }
	    	}, ClickEvent.getType());
	      
	}
	
	private void loadTokenPage(){
		formPanel.clear();
		formPanel.add(Page1.getInstance());
    	outer.add(formPanel);
    	RootLayoutPanel.get().add(outer);
	}
	
	private void loadLinksPage(){
		formPanel.clear();
		formPanel.add(Page2.getInstance());
    	outer.add(formPanel);
    	RootLayoutPanel.get().add(outer);
	}
	
	private void loadTriggersPage(){
		formPanel.clear();
		try {
		formPanel.add(Page3.getInstance());
		} catch (RequestException e) {
			
		}
    	outer.add(formPanel);
    	RootLayoutPanel.get().add(outer);
	}
	
	private void loadPayoffsPage(){
		formPanel.clear();
		formPanel.add(Page4.getInstance());
    	outer.add(formPanel);
    	RootLayoutPanel.get().add(outer);
	}
	
	private void loadFileDownloadPage(){
		formPanel.clear();
		formPanel.add(Page5.getInstance());
    	outer.add(formPanel);
    	RootLayoutPanel.get().add(outer);
	}
	
	private void loadFileUploadPage(){
		formPanel.clear();
		formPanel.add(Page6.getInstance());
    	outer.add(formPanel);
    	RootLayoutPanel.get().add(outer);
	}
	
	private void loadAnalyticsPage(){
		formPanel.clear();
		formPanel.add(Page7.getInstance());
    	outer.add(formPanel);
    	RootLayoutPanel.get().add(outer);
	}

}
