
describe("Test for Find() in Cypress",()=>{


it("Test for footers link for Freshworks app",()=>{

    //open application
    cy.visit("https://www.freshworks.com/");


    /*
    find(): help you to identify decendent(child)
    find() only works with get()
    cy.get(parent).find(decendent)
    */
    //footerlink
    //cy.get("ul.dRHBZS>li>a>span").each(($footerLink)=>{
    cy.get("ul.dRHBZS").find("li>a>span").each(($footerLink)=>{

        cy.log($footerLink.text());
    })
})


})