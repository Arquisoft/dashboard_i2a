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
    public void theDatabaseGetsAConnection() throws Throwable{
        pDao= Persistence.getProposalDao();
    }

    @Then("^the application gets the proposal$")
    public void theApplicationGetsTheProposal(){
        p=pDao.getProposals();
        Assert.assertNotNull(p);
    }

    @And("^the list is not empty?")
    public void theListIsNotEmpty(){
        Assert.assertTrue(!p.isEmpty());
    }
}
