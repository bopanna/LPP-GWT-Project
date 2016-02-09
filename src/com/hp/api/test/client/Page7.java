package com.hp.api.test.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Page7 extends Composite {
	private VerticalPanel page7 = new VerticalPanel();
    private TabPanel tabPanel = new TabPanel();
    static private Page7 _instance = null;
    
    public Page7(){
        initPage();
        initWidget(page7);
    }

    public static Page7 getInstance(){
        if(null == _instance) {
            _instance = new Page7();
        }
        return _instance;
    }

    private void initPage() {
    	
    	page7.setWidth("100%");
    	page7.setHeight("100%");
    	
    	VerticalPanel panel = new VerticalPanel();
    	
        // Create a ListBox, giving it a name and 
        // some values to be associated with its options.
        HorizontalPanel triggerType = new HorizontalPanel();
    	Label tr = new Label("Trigger Type");
        ListBox lb = new ListBox();
        lb.addItem("watermark", "watermark");
        lb.addItem("shorturl", "shorturl");
        lb.addItem("qrcode", "qrcode");
        lb.setWidth("220");
        triggerType.add(tr);
        triggerType.add(lb);
        triggerType.setSpacing(2);
        
        ListBox lb2 = new ListBox();
        lb2.setName("State");
        lb2.addItem("active", "active");
        lb2.addItem("inactive", "inactive");
        lb2.setWidth("220");
    	
        HorizontalPanel hpDis = new HorizontalPanel();
    	Label disLabel = new Label("Name");
        TextBox tb = new TextBox();
        tb.setName("textBoxFormElement");
        hpDis.add(disLabel);
        hpDis.add(tb);
        hpDis.setSpacing(2);
        
        ListBox lb3 = new ListBox();
        lb3.setName("typefriendly");
        lb3.addItem("true", "true");
        lb3.addItem("false", "false");
        lb3.setWidth("220");
        
        panel.add(triggerType);
        panel.add(lb2);
        panel.add(hpDis);
        panel.add(lb3);
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
        page7.add(tabPanel);
        
    }
}