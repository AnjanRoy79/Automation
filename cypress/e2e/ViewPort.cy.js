

describe("Test browser maximize and minimize support in Cypress",()=>{

it("Test for viewport in cypress",()=>{

    cy.visit("https://automationplayground.com/crm/");



    //defualt size: 1000*660
    //full HD screen 1920 * 1080
    cy.viewport(1920,1080);

    cy.wait(2000);

    cy.viewport(300,500);

      cy.wait(2000);

      cy.viewport(1000,660);

       cy.wait(2000);

       cy.viewport("iphone-8");

})



})