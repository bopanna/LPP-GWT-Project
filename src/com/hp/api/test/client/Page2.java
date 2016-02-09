package com.hp.api.test.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Page2 extends Composite {
    private TabPanel page2 = new TabPanel();
    static private Page2 _instance = null;
    
    public Page2(){
        initPage();
        initWidget(page2);
    }

    public static Page2 getInstance(){
        if(null == _instance) {
            _instance = new Page2();
        }
        return _instance;
    }

    private void initPage() {
    	
    	page2.setWidth("100%");
    	page2.setHeight("100%");

        //create contents for tabs of tabpanel
        Label label1 = new Label("This is contents of TAB 1");
        label1.setHeight("100%");
        Label label2 = new Label("This is contents of TAB 2");
        label2.setHeight("100%");
        Label label3 = new Label("This is contents of TAB 3");
        label3.setHeight("100%");

        //create titles for tabs
        String tab1Title = "TAB 1";
        String tab2Title = "TAB 2";
        String tab3Title = "TAB 3";

        //create tabs 
        page2.add(label1, tab1Title);
        page2.add(label2, tab2Title);
        page2.add(label3, tab3Title);

        //select first tab
        page2.selectTab(0);
        
    }
}