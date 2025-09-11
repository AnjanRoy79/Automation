describe("Test for orange hrm menu list",()=>{

it("Login and get munu list",()=>{

cy.visit("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

cy.get("input[name='username']").type("Admin");

cy.get("input[name='password']").type("admin123");

cy.get("button").click();

cy.get("ul.oxd-main-menu>li").each(($list)=>{
    cy.log("Menu text is: "+$list.text());
  
})

cy.wait(2000);
cy.contains("Admin").click();
cy.url().should("include","admin");
cy.log("clicked on admin successfuly");
cy.wait(2000);
  cy.get("i.oxd-userdropdown-icon").click();
    cy.contains("Logout").click();
    cy.log("Logout Sucessful");

})

})