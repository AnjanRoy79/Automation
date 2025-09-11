/*
Note: To interact with title,url and single webelement use then()
      To interact with multiple webelement match use each()

Scenario:Get the title of application store it into variable and then print
-----------------------------------------------------------
Syntax:
---------
cy.title().then((variableName)=>{

    cy.log(variableName)
    })

Scenario:Get the Url of application store it into variable and then print
--------------------------------------------------------
Syntax:
---------
cy.url().then((variableName)=>{

    cy.log(variableName)
    })

Scenario:get the element control store it into variable and then do action
--------------------------------------------------------
For Webelement add $sign before variable name
Syntax:
-------------
cy.get(Locator).then(($variableName)=>{
    
    //action: get the text of element:text()
    cy.log($variableName.text())

    //action like click use wrap()
    cy.wrap($variableName).click()

    //action like type: use Wrap()
    cy.wrap($variableName).type()

    
    })
*/


describe("This is for Cypress Variables",()=>{


it("To get url of Google and print the same",()=>{

    //open application
    cy.visit("https://www.google.com");

    // cy.log("Title is: "+cy.title());
    // cy.log("URL is: "+cy.url());
    cy.url().then((appUrl)=>{//here apUrl is variable name which store url of app

        cy.log("Application url is: "+appUrl);
    })



})

it("Test for title of OrangeHrm",()=>{
    cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    //to get title and print it use then()
    cy.title().then((appTitle)=>{//here appTitle is variable whitch store current title of app
        cy.log("Application title is: "+appTitle);


    })


})

it.only("Test for Element",()=>{
    cy.visit("https://tutorialsninja.com/demo/index.php?route=account/login");

    //Returning Customer ele: get the text of this element
    cy.get("h2").eq(1).then(($textEle)=>{

        cy.log("Text of Element is: "+$textEle.text());

    })

    //get the email element and store it into variable and perform action

    cy.get("#input-email").then(($emailEle)=>{//$emailEle is variable name

        //click
        cy.wrap($emailEle).click().type("testest")

        //type
       // cy.wrap($emailEle).type("test24@gmail.com");
    })
})

})

//Note: single webelement/title/url: then()


describe("Test for variable",()=>{

it("Test for title and url with variable",()=>{

    //open application
    cy.visit("https://tutorialsninja.com/demo/index.php?route=account/login");

    cy.log("Url is : "+cy.url());//No

    //cypress variable
    cy.url().then((appUrl)=>{//appUrl is variable name

        if(appUrl.includes("https"))
        {
            cy.log("true.....");
        cy.log("Application url is: "+appUrl);
        }

    })


    //title
    cy.log("Application title is: "+cy.title());//not print title

    cy.title().then((appTitle)=>{

      cy.log("Application title is: "+appTitle);  
    })




})


it.only("Test for WebElement with variable",()=>{

//open application
    cy.visit("https://tutorialsninja.com/demo/index.php?route=account/login");

    //email
    //cy.get("#input-email").type("test24@gmail.com");

    //variable
    cy.get("#input-email").then(($emailEle)=>{

        cy.wrap($emailEle).click().type("test25@gmail.com");

    })


})



})