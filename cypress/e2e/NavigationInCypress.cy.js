

/*
cy.go("back"/"forward",-1)
*/

describe("Test for Navigation",()=>{

it("Test Amazon App navigation",()=>{


    //open application
cy.visit("https://www.amazon.in/");

//assert title should have India
cy.title().should("include","India");

//open next page--Mobiles page
cy.contains("Mobiles").click();

//pause
cy.wait(2000);

//go back to the home page
cy.go("back");

cy.wait(2000);

//forward
cy.go("forward");

cy.wait(2000);
//refresh page cy.reload()
cy.reload();

})


})