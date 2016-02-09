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

public class Page1 extends Composite {
    
    private TabPanel page1 = new TabPanel();
    static private Page1 _instance = null;
    
    public Page1(){
        initPage();
        initWidget(page1);
    }

    public static Page1 getInstance(){
        if(null == _instance) {
            _instance = new Page1();
        }
        return _instance;
    }

    private void initPage() {
    	
    	page1.setWidth("100%");
    	page1.setHeight("100%");

        //create contents for tabs of tabpanel
        Label label1 = new Label("This is contents of TAB 1");
        Label label2 = new Label("This is contents of TAB 2");
        Label label3 = new Label("This is contents of TAB 3");

        //create titles for tabs
        String tab1Title = "TAB 1";
        String tab2Title = "TAB 2";
        String tab3Title = "TAB 3";

        //create tabs 
        page1.add(label1, tab1Title);
        page1.add(label2, tab2Title);
        page1.add(label3, tab3Title);

        //select first tab
        page1.selectTab(0);
    }
}