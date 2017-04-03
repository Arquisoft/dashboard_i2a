package dashboard.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dashboard.dto.Proposal;
import dashboard.persistence.Persistence;
import dashboard.persistence.ProposalDao;
import org.junit.Assert;

import java.util.List;

public class CucumberPersistence {
    private ProposalDao pDao;
    private List<Proposal> p;

    @When("^the database gets a connection$")
    public void the_database_gets_a_connection() throws Throwable{
        pDao= Persistence.getProposalDao();
    }

    @Then("^the application gets the proposal$")
    public void the_application_gets_the_proposal(){
        p=pDao.getProposals();
        Assert.assertNotNull(p);
    }

    @And("^the list is not empty?")
    public void the_list_is_not_empty(){
        Assert.assertTrue(!p.isEmpty());
    }
}
