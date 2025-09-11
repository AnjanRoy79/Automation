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

describe("Test for Locators in cypress",()=>{


it("Test for Orangehrm login and logout",()=>{

//open application
cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//username
cy.get("input[name='username']").type("Admin");

//password
cy.get("input[placeholder='Password']").type("admin123");

//login
cy.get("button").click();

//logout
cy.get("i.oxd-userdropdown-icon").click();

//list:parent to child with indexing
cy.get("ul.oxd-dropdown-menu>li:nth-child(4)").click();

//basic
//cy.contains("Logout").click();

})

})
