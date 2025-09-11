/*

To Open any application
=============================
cy.visit(appurl)

To get the title of application
=================================
cy.title()

To get the current url of application
====================================
cy.url()

Assertions
=================
Cypress use Mocha framework and chai assertion library
Cypress support inbuilt assertion that is called Implicit

should()
and()

Explicit
==========
expect():BDD
assert(): TDD


*/


describe("This is suite for title and url validation",()=>{

//pass case scenario
it("Test for valid title for Google application",()=>{

    //open application
    cy.visit("https://www.google.com");

    //To get the title : title()
    cy.title().should("eq","Google");
    cy.screenshot("valid title")

})

//fail case scenario
it("Test for invalid title of Google application",()=>{

    //open application
    cy.visit("https://www.google.com");
    

    //to get the title: title()
    cy.title().should("eq","GoogleApp");
    cy.screenshot("invalid title")
})


it("Test for validation valid url of Google",()=>{

    //open application
    cy.visit("https://www.google.com/");


    //to get the current url: url()
    cy.url().should("eq","https://www.google.com/");//exact match

    cy.screenshot("Valid URL");
    
    //partial match
    cy.url().should("include","https");

})

})

