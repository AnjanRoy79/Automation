/*Assertions
=================
Assertion will help you to check current status of application

types of Assertion in Selenium as per TestNG
=====
Hard Assertion 
-------------------

Soft Assertion
---------------

Cypress use Mocha framework and chai assertion library
Cypress support inbuilt assertion that is called Implicit

should()
and()

Explicit
==========
Rule: All Explicit assertions work with variables
expect():BDD
assert(): TDD


All assertions are Hard assertion type
-------------------------
If assertion fail test will stop execution on that line
*/


describe("Test for Assertions in cypress",()=>{

it("Test for Inbuit Assertion",()=>{

    //open application
    cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    //validate title of application using should():implicit
    cy.title().should("eq","OrangeHRM");//exact match
    cy.title().should("include","HRM");//partial match
    cy.title().should("contain","Orange");//partial match

    //and(): concat where multiple assertions we can write in one line
    cy.title().should("eq","OrangeHRM").and("include","HRM");

    //test for username text box it should be visible and enable
    cy.get("input[placeholder='Username']").should("be.visible").and("be.enabled").type("Priyanka").and("have.value","Priyanka");

    //text assertion
    cy.get("h5").should("have.text","Login");

})


it("Test for Explicit Assertion",()=>{
//open application
cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//explicit assertion apply for variable
cy.get("input[name='username']").type("Jay");

//store it into variable
cy.get("input[name='username']").then(($userNameEle)=>{

    //get the current value: val() is the keyword
    let username=$userNameEle.val();

    //do assert the same: check value is matching with Jay
    //expect(): BDD
    expect(username).to.eq("Jay");
    cy.log("Explicit assertion matched!");

    //assert():TDD
    assert.equal(username,"Jay");
    cy.log("Assert is matched!")

})



})

it.only("Test assertion for Checkbox or radiobutton",()=>{

cy.visit("https://the-internet.herokuapp.com/checkboxes");

/*
default status
---------------------
checkbox1 should be unchecked 
checkbox2 should be checked
*/
//checkbox1: eq(index)
cy.get("input[type='checkbox']").eq(0).should("not.be.checked");
cy.log("Initially check box in unchecked!");

//checkbox2
cy.get("input[type='checkbox']").eq(1).should("be.checked");
cy.log("Initially check box is checked!")


})

})
