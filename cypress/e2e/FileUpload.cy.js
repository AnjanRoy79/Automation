
/*
Fixtures folder:
-------------------
For selecting or file reading is only possible
when file is available in Fixtures folder.


*/


describe("Test selectFile() for file selection",()=>{

it("Test for file upload",()=>{

//open app
cy.visit("https://the-internet.herokuapp.com/upload");

//select file
cy.get("#file-upload").selectFile("C:/Users/anjan.ray/Desktop/ExtentITestNGListeners.java");

//upload file
cy.get("#file-submit").click();

//assertion
cy.get("h3").should("have.text","File Uploaded!");

})



})