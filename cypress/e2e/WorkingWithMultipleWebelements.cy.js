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

    
    })*/



describe("Test for Multiple WebElements with variable",()=>{


it("Test for opencart menu ",()=>{

//open application
cy.visit("https://tutorialsninja.com/demo/index.php?route=account/login");

//list of elements use each()

cy.get("div.list-group>a").should("have.length",13); // checking the total size of the menu

//get the text of element in console
cy.get("div.list-group>a").each(($links)=>{

    //get the text: text()
    cy.log("Link text is: "+$links.text());

    //get the attribute value in cypress:  attr("attribute name") is the syntax
    cy.log("value for href attribute: "+$links.attr("href"));

    if($links.text().includes("Forgotten Password"))
    {
        cy.log("Link found!.............")
        //click on that option/link
        cy.wrap($links).click();

    }

})
})



it("Test for google search scenario",()=>{

//open application
cy.visit("https://www.google.com/");

//search for keyword
cy.get("#APjFqb").type("Jenkins");

//list of options from google get it in console
cy.get("ul.G43f7e>li").each(($option)=>{

    cy.log("Option is: "+$option.text());

})




})

it.only("Orangehrm total links validation",()=>{


//open application
cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//total links are 5
cy.get("a").should("have.length",5); // have.length is a method

//get the text and href attribute value
cy.get("a").each(($link)=>{

    cy.log("Text is: "+$link.text());
    cy.log("Href value is: "+$link.attr("href"));

})


})

})
