/*
Cypress support two tags
--------------------------
1. .only
2. .skip

Tags applicable for suite as well as test
*/

describe("This is suite1",()=>{

it("This is google test",()=>{
    cy.visit("https://www.google.com");
    cy.log("Google app open");

})

it("Test is Amazon test",()=>{
    cy.visit("https://www.amazon.in");
    cy.log("Amazon app open");
})

it("Test CRM app",()=>{
    cy.visit("https://automationplayground.com/crm/");
    cy.log("CRM app open");
})

})


//suite2
describe.only("This is suite2",()=>{ // .only will run this suite and skip the first one

    it("Test for open cart app",()=>{

        cy.visit("https://tutorialsninja.com/demo/index.php?route=account/register");
        cy.log("This is Open Cart application....");
    })
})
