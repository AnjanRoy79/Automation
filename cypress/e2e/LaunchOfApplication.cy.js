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

*/
describe("This is for launching web applications",()=>{


it("This is test for google application",()=>{

    cy.visit("https://www.google.com"); 
    cy.log("This is Google app....")
})


it("This is test for Amazon application",()=>{
    cy.visit("https://www.amazon.in");
    cy.log("This is Amazon app....");
    
})
})

