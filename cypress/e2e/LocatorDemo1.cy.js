/*
Locators in cypress
=====================

How to identify any WebElement(GUI)
--------------------------------------
We can identify element by it address from that webpage that is Locator

Locator is address of the webElement from webpage


To identify any Webelement cypress use get()
---------------------------------------
cy.get(Locator strategy)

Cypress support 4 locators
==========================
1. cy.contains()
---------------------------
Cypress identify weblement as per visible text of that weblement

<a href="" id="">Login</a>

visibile text is: Login

2.using tag name
---------------------
Syntax:
-----------
cy.get("tagname of element")


3.Using cssSelector
=======================
What is cssSelector?
------------------
CssSelector is Locator strategy to identify weblelement based on there css properties
-CssSelector can travel in one direction like parent to child
-CssSelector is faster than xpath

1.using tagname with id
----------------------------
Syntax:
-------------
tagname#id

Example:
-------------
<input id="abc">

input#abc

2.using tagname with classname
--------------------------------
Syntax:
-------------
tagname.classname

Example:
---------------
<input id="abc" class="btn btn2">

input.btn.btn2

3.using tagname with attribute
--------------------------------
Syntax:
-------------
tagname[attribute='value']

Example:
-------------
<input type="text" id="" class="">

input[type='text']


CssSelector for parent to child node
------------------------------------
parent element>childelement

CssSelector with indexing
------------------------------
parent tagname:nth-child(index)


4.Using xpath(external plugin)
-----------------------------
*/

describe("This is for Locators in Cypress",()=>{


it("Test CRM login functionality",()=>{

//open application
cy.visit("https://automationplayground.com/crm/");

//Locator strategy1: cy.contains(): based on visible text it will identify element
//cy.contains("Sign In").click(); 

//Locator startegy2: Using cssSelector with id
cy.get("a#SignIn").click();

//Locator startegy: Using cssSelector with id: enter email into emailInputbox
cy.get("#email-id").type("test@gmail.com");

//Locator startegy: Using cssSelector with attribute
cy.get("input[placeholder='Password']").type("test123");

/*
checkbox/radiobutton automation
-----------------------------
check()
uncheck()
*/

//Locator startegy: Using cssSelector with id
cy.get("#remember").check();

//add wait for 2sec like Thread.sleep() in selenium
cy.wait(2000);

//uncheck same check box
cy.get("#remember").uncheck();

cy.wait(2000);
cy.get("#remember").check();

//Locator startegy: Using cssSelector with className
//cy.get("button.btn-primary").click();

//Locator Strategy: Using tagName
cy.get("button").click();

//assertion: asserting url address
//cy.url().should("include","customers");
//cy.log("User login completed!")

cy.title().should("include","Customers");
cy.log("User login completed!")
})

})