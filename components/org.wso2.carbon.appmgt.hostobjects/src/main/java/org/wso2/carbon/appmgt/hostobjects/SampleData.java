/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.appmgt.hostobjects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.appmgt.api.model.*;
import org.wso2.carbon.appmgt.api.model.WebApp;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


class SampleData {
     private static final Log log = LogFactory.getLog(SampleData.class);

    static String[] providers = {"Madhuka", "Lalaji", "Chanaka", "Sumedha"};
    static String[] application = {"News Application", "Location Applicatioin", "Stock Application", "WSO2 Application"};
    static purchasedServices p1 = new purchasedServices("/branches/production/services/net/webservicex/www/6.0.0/BarCode", "false", "Barcode generator", "http://wso2.org/forum/990", "6.0.0", "WSO2", "3.0", "http://www.webservicex.net/", "BarCode", "true", "https://lh3.ggpht.com/1Z3IovVFnCBWTRCB_0AGALYKho_ipprAYV-XwJhhFEKx6U-FEVAIJI0QXZ8MDfiUeywa=w78");
    static purchasedServices p2 = new purchasedServices("/branches/production/services/net/webservicex/www/6.0.0/BizService", "false", "BizService generator", "http://wso2.org/forum/990", "5.0.0", "WSO2", "3.0", "http://www.webservicex.net/", "BizService", "true", "https://lh3.ggpht.com/1Z3IovVFnCBWTRCB_0AGALYKho_ipprAYV-XwJhhFEKx6U-FEVAIJI0QXZ8MDfiUeywa=w78");
    static purchasedServices[] purchasedServiceList = {p1, p2};

    static Services s1 = new Services("Biz Service", 3, "Nuwan");
    static Services s2 = new Services("News Service", 5, "Sumedha");
    static Services s3 = new Services("Stocks", 4, "Madhuka");
    static Services[] listSerives = {s1, s2, s3};

    APIIdentifier apiI1 = new APIIdentifier("Madhuka", "RadioServices", "4.0.1");
    APIIdentifier apiI2 = new APIIdentifier("Sumedha", "ProjectServices", "1.2.0");
    APIIdentifier apiI3 = new APIIdentifier("Lalji", "BizServices", "2.0.2");
    APIIdentifier apiI4 = new APIIdentifier("Chanaka", "GraphicServices", "3.0.1");
    APIIdentifier apiI5 = new APIIdentifier("Lalaji", "TestServices", "4.0.1");
    APIIdentifier apiI6 = new APIIdentifier("Madhuka", "HelloServices", "5.0.1");
    APIIdentifier apiI7 = new APIIdentifier("Sumedha", "Test1Services", "6.0.1");
    APIIdentifier apiI8 = new APIIdentifier("Chanaka", "Test2Services", "1.1.6");
    WebApp api1 = new WebApp(apiI1);
    WebApp api2 = new WebApp(apiI2);
    WebApp api3 = new WebApp(apiI3);
    WebApp api4 = new WebApp(apiI4);
    WebApp api5 = new WebApp(apiI5);
    WebApp api6 = new WebApp(apiI6);
    WebApp api7 = new WebApp(apiI7);
    WebApp api8 = new WebApp(apiI8);

    Subscriber sub1=new Subscriber("lalaji@wso2.com");
    Subscriber sub2=new Subscriber("madhuka@wso2.com");
    Subscriber sub3=new Subscriber("lalaji@wso2.com");

    public Set<Subscriber> getUsers() {
        Set<Subscriber> users=new HashSet<Subscriber>();
        sub1.setDescription("Testing1");
        sub1.setName("Lalaji");
        sub2.setName("Maduka");
        sub2.setDescription("Testing2");
        sub3.setDescription("Testing3");
        sub3.setName("Lalaji");
        users.add(sub1);
        users.add(sub2);
        users.add(sub3);
        return users;
    }

    public void addWebApp(String name, String version, String description, String endpoint,
                       String wsdl, Set<String> tag, String tier) {
        Set<Tier> availableTier=new HashSet<Tier>();
        availableTier.add(new Tier(tier));


        APIIdentifier aid = new APIIdentifier(name, version, "public");
        WebApp api = new WebApp(aid);
        api.setDescription(description);
        api.setUrl(endpoint);
        //api.setWSDL();
        api.addTags(tag);
        api.addAvailableTiers(availableTier);
        log.info("Successfully added the WebApp");

    }

    public APIIdentifier[] giveAPIIdentifiers() {
        APIIdentifier[] arrayAPIIdentifiers = {apiI1, apiI2, apiI3, apiI4};
        return arrayAPIIdentifiers;
    }

    public WebApp getAPI() {
        Set<Tier> availableTier = new HashSet<Tier>();
        availableTier.add(new Tier("gold"));
        availableTier.add(new Tier("silver"));
        api1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce suscipit porta leo vitae pellentesque. In" +
                            " volutpat viverra tortor id iaculis. Cras eleifend, risus ut eleifend porttitor, risus dolor tincidunt magna," +
                            " u elementum sapien dui eget elit. Nullam et nisl ac velit molestie pulvinar sed quis elit. Vestibulum non" +
                            "malesuada sem. Praesent rutrum sagittis iaculis. Quisque blandit, lacus ut tincidunt egestas, purus elit" +
                            "rhoncus nunc, vel venenatis purus nisl at magna. Phasellus vitae sem diam. Donec imperdiet, velit sodales"+
                            " rutrum malesuada, nibh lacus vehicula lorem, id sagittis enim turpis et enim. Duis pharetra laoreet lorem" +
                            "  sit amet euismod.");
        api1.setLastUpdated(new Date(12 / 10 / 2011));
        api1.setLatest(true);
        api1.setStatus(APIStatus.DEPRECATED);
        api1.setUrl("http://appserver/services/hello");
        api1.addAvailableTiers(availableTier);
        return api1;

    }

    public Set<WebApp> getAllPublishedAPIs() {

        Set<WebApp> apis = new HashSet<WebApp>();
        apis.add(api1);
        apis.add(api2);
        apis.add(api3);
        apis.add(api4);
        apis.add(api5);
        apis.add(api6);
        apis.add(api7);
        apis.add(api8);
        Set<Tier> availableTier = new HashSet<Tier>();
        availableTier.add(new Tier("gold"));
        availableTier.add(new Tier("silver"));


        Iterator it = apis.iterator();
        while (it.hasNext()) {
            Object apiObject = it.next();
            WebApp api = (WebApp) apiObject;
            api.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce suscipit porta leo vitae pellentesque. In" +
                               "volutpat viverra tortor id iaculis. Cras eleifend, risus ut eleifend porttitor, risus dolor tincidunt magna," +
                               "eu elementum sapien dui eget elit. Nullam et nisl ac velit molestie pulvinar sed quis elit. Vestibulum non" +
                               "malesuada sem. Praesent rutrum sagittis iaculis. Quisque blandit, lacus ut tincidunt egestas, purus elit" +
                               "rhoncus nunc, vel venenatis purus nisl at magna. Phasellus vitae sem diam. Donec imperdiet, velit sodales" +
                               "rutrum malesuada, nibh lacus vehicula lorem, id sagittis enim turpis et enim. Duis pharetra laoreet lorem" +
                               "sit amet euismod.");
            api.setLastUpdated(new Date(12 / 10 / 2011));
            api.setLatest(true);
            api.setStatus(APIStatus.DEPRECATED);
            api.setUrl("http://appserver/services/echo");
            api.addAvailableTiers(availableTier);

        }
        return apis;
    }


}

class Services {
    String name;

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }

    int rating;
    String author;

    public Services(String n, int r, String a) {
        this.name = n;
        this.rating = r;
        this.author = a;
    }
}

class purchasedServices {
    String path;
    String purchased;
    String description;
    String supportForumURL;
    String version;
    String author;
    String rating;
    String namespace;
    String name;
    String canDelete;
    String thumbURL;

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }

    public String getVersion() {
        return version;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public String getSupportForumURL() {
        return supportForumURL;
    }

    public String getPurchased() {
        return purchased;
    }

    public String getCanDelete() {
        return canDelete;
    }


    public purchasedServices(String path, String purchased, String description,
                             String supportForumURL, String version, String author, String rating,
                             String namespace, String name, String canDelete, String thumbURL) {
        this.author = author;
        this.canDelete = canDelete;
        this.description = description;
        this.name = name;
        this.namespace = namespace;
        this.path = path;
        this.purchased = purchased;
        this.rating = rating;
        this.supportForumURL = supportForumURL;
        this.thumbURL = thumbURL;
        this.version = version;

    }


}