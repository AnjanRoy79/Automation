
describe("Test Alerts",()=>{

it("Automate simple alert",()=>{
//open app
cy.visit("https://the-internet.herokuapp.com/javascript_alerts");


//click on button to open alert
cy.contains("Click for JS Alert").click();
//cypress automatically handle alert!

//add event for manual validation
cy.on("window:alert",(alt1)=>{

    expect(alt1).to.equal("I am a JS Alert");
    
})

//assertion
cy.get("#result").should("have.text","You successfully clicked an alert");

})

it("Automate confirmation alert",()=>{
    cy.visit("https://the-internet.herokuapp.com/javascript_alerts");

    //open
    cy.contains("Click for JS Confirm").click();

    //click on cancel
    cy.on("window:confirm",(alt2)=>false);

    //assertion on result
    cy.get("#result").should("have.text","You clicked: Cancel");

})


it.only("Automate Prompt alert",()=>{

//open app
cy.visit("https://the-internet.herokuapp.com/javascript_alerts");

//take control of alert window and do prompt
cy.window().then((win)=>{

    //stubbing
    cy.stub(win,"prompt").returns("Bye EveryOne!");
})


//open alert
cy.contains("Click for JS Prompt").click();

//assertion
cy.get("#result").should("have.text","You entered: Bye EveryOne!");




})

})