
/*

1.before()/beforeAll():
-------------------------
2.after()
3.beforeEach()
4.afterEach()
*/

describe("Test Hooks in cypress",()=>{


before(()=>{
    cy.log("Before hook will execute before all test cases only once");
    //any project ,server setup 
})

after(()=>{
    cy.log("After hook will execute after all test cases only once")
    //screenshots,reports
})

beforeEach(()=>{
    cy.log("BeforeEach hook will execute before every test case.....")
    //open application
    cy.visit("https://automationplayground.com/crm/");
})

afterEach(()=>{
    cy.log("AfterEach hook will execute after every test case....");
    //get the url and print
    cy.url().then((appUrl)=>{
        cy.log("Application url is: "+appUrl);
    })
})

it("Test for Sign In Link ",()=>{

    //open application
    //cy.visit("https://automationplayground.com/crm/");

    //identify element
    cy.contains("Sign In").should("be.visible").click();

    //assertion for next page navigation
    cy.url().should("include","login");
    cy.log("Sign In link is working....");
})

it("Test for Login Functionality",()=>{

    //open application
    //cy.visit("https://automationplayground.com/crm/");

    //click on Signin
cy.contains("Sign In").click();

//email
cy.get("#email-id").type("test@gmail.com");
//password
cy.get("#password").type("test123");
//button
cy.get("#submit-id").click();

//assertion
cy.url().should("include","customers");
cy.log("Login Completed!......");

})

})