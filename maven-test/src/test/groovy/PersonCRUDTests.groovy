import geb.junit4.GebReportingTest

import pages.*
import org.junit.Test

class PersonCRUDTests extends GebReportingTest {

    @Test
    void doSomeCrud() {
    
    	println("baseUrl = " + baseUrl)
    
        to ListPage
        assert personRows.size() == 0
        newPersonButton.click()
        
        assert at(CreatePage)
        $("#enabled").click()
        firstName = "Luke"
        lastName = "Daley"
        createButton.click()
        
        assert at(ShowPage)
        assert enabled == true
        assert firstName == "Luke"
        assert lastName == "Daley"
        editButton.click()
        
        assert at(EditPage)
        $("#enabled").click()
        updateButton.click()
        
        assert at(ShowPage)
        
        to ListPage
        assert personRows.size() == 1
        def row = personRow(0)
        assert row.firstName == "Luke"
        assert row.lastName == "Daley"
        row.showLink.click()
        
        assert at(ShowPage)
        def deletedId = id
        withConfirm { deleteButton.click() }
        
        assert at(ListPage)
        assert message == "Person $deletedId deleted"
        assert personRows.size() == 0
    }
}