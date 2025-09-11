/*
If dropdown is designed with <select> tag then use select()
by index,by visible text and by value you can select option

*/

describe("Test different styles of dropdown",()=>{


it("Automate select tag based dropdown",()=>{

    //open application
    cy.visit("https://www.amazon.in/");

    //identify select based dropdown
    cy.get("#searchDropdownBox").select(3,{force: true});//select option as per indexing

    cy.wait(2000);

    //select with visible text
    cy.get("#searchDropdownBox").select("Gift Cards");

    cy.wait(2000);

    //select by value
    cy.get("#searchDropdownBox").select("search-alias=home-improvement",{force: true})



})


it.only("Test for Goibibo appdropdown (without select tag)",()=>{

//open app
cy.visit("https://www.goibibo.com/flights");

//close the popup
cy.get("span.icClose").click();

//from dropdown
cy.contains("Enter city or airport").eq(0).click();

//input box
cy.get("input[type='text']").type("p");

//list
// cy.get("ul#autoSuggest-list>li").each(($option)=>{
//     cy.log($option.text());
// })

cy.get("ul#autoSuggest-list>li>div>div>div>p>span.autoCompleteTitle").each(($option)=>{

    cy.log($option.text());
    if($option.text().includes("Pantnagar, India"))
    {
        cy.wrap($option).click();
    }
})



})

})