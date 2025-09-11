/*
What is xpath?
------------------
Xpath is path of the html/xml element form html or xml document

Types of xpath
==============
1.Absolute xpath
--------------
-starts with root node(html)
-starts with '/'

2.Relative xpath
---------------------
-identify element based on relative property
-starts with '//'

Syntax:
-------------
//tagname[@attribute='value']




*/


describe("This suite for Xpath locator",()=>{


it("Test for Opencart login",()=>{
    //opena pplication
    cy.visit("https://tutorialsninja.com/demo/index.php?route=account/login");

//email
cy.xpath("//input[@placeholder='E-Mail Address']").type("test24@gmail.com");

//password
cy.xpath("//input[@type='password']").type("test123");

//login
cy.xpath("//input[@value='Login']").click();

})
})
