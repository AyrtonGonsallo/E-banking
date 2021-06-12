package com.projetJEE.Ebanking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.projetJEE.Ebanking.Dao.AdminRepository;
import com.projetJEE.Ebanking.Dao.AgenceRepository;
import com.projetJEE.Ebanking.Dao.AgentRepository;
import com.projetJEE.Ebanking.Dao.ClientRepository;
import com.projetJEE.Ebanking.Dao.CompteRepository;
import com.projetJEE.Ebanking.Dao.DeviseRepository;
import com.projetJEE.Ebanking.Dao.OperateurRepository;
import com.projetJEE.Ebanking.Dao.OperationRepository;
import com.projetJEE.Ebanking.Dao.RechargeRepository;
import com.projetJEE.Ebanking.Dao.VirementRepository;
import com.projetJEE.Ebanking.entities.Admin;
import com.projetJEE.Ebanking.entities.Agence;
import com.projetJEE.Ebanking.entities.Agent;
import com.projetJEE.Ebanking.entities.Client;
import com.projetJEE.Ebanking.entities.Compte;
import com.projetJEE.Ebanking.entities.Devise;
import com.projetJEE.Ebanking.entities.Operation;
import com.projetJEE.Ebanking.entities.Recharge;
import com.projetJEE.Ebanking.entities.Virement;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class EBankingApplication implements CommandLineRunner {

	@Autowired
	private AgenceRepository agenceR;
	@Autowired
	private ClientRepository clientR;
	@Autowired
	private CompteRepository compteR;
	@Autowired
	private AgentRepository agentR;
	@Autowired
	private AdminRepository adminR;
	@Autowired
	private DeviseRepository deviseR;
	@Autowired
	private RechargeRepository rechargeR;
	@Autowired
	private VirementRepository virementR;
	@Autowired
	private OperateurRepository operateurR;
	@Autowired
	private OperationRepository operationR;
	
	//pour recuperer le id des articles 
	@Autowired
	private RepositoryRestConfiguration rrc;
	
	public static void main(String[] args) {
		SpringApplication.run(EBankingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String[] noms={"Dark","Allen","Jones"};
		String[] prenoms={"Marco","Paul","Alain"};
		String[] usernames={"admin","allen","jones"};
		String[] passwords={"madagascar","allen","jones"};
		
		//pour recuperer le id des articles 
		rrc.exposeIdsFor(Client.class,Compte.class,Agent.class);
		List<Client>clients=new ArrayList<Client>();
		List<Agent>agents=new ArrayList<Agent>();
		List<Compte>comptes1=new ArrayList<Compte>();
		List<Compte>comptes2=new ArrayList<Compte>();
		List<Compte>comptes3=new ArrayList<Compte>();
		List<List<Compte>>comptes=new ArrayList<List<Compte>>();
		comptes.add(comptes1);
		comptes.add(comptes2);
		comptes.add(comptes3);
		List<Virement>virements_envoyés1=new ArrayList<Virement>();
		List<Virement>virements_envoyés2=new ArrayList<Virement>();
		List<Virement>virements_envoyés3=new ArrayList<Virement>();
		
		
		List<Virement>virements_recus1=new ArrayList<Virement>();
		List<Virement>virements_recus2=new ArrayList<Virement>();
		List<Virement>virements_recus3=new ArrayList<Virement>();
		
		
		List<Operation>operations1=new ArrayList<Operation>();
		List<Operation>operations2=new ArrayList<Operation>();
		List<Operation>operations3=new ArrayList<Operation>();
		
		
		//creer les client
		for(int i=0;i<noms.length;i++){
			Client c=new Client("oui",null,null,null);
			c.setNom(noms[i]);
			c.setAdresse(RandomString.make(15));
			c.setEmail("paul@gmail.com");
			c.setPrenom(prenoms[i]);
			c.setPassword(passwords[i]);
			c.setUsername(usernames[i]);
			c.setRole("");
			c.setComptes(comptes.get(i));
			clientR.save(c);
			clients.add(c);
			
		}
		
			//un admin
			Admin admin1=new Admin();
			admin1.setPassword(RandomString.make(18));
			admin1.setUsername(RandomString.make(18));
			admin1.setRole("admin");
			//un admin2
			Admin admin2=new Admin();
			admin2.setPassword(RandomString.make(18));
			admin2.setUsername(RandomString.make(18));
			admin2.setRole("admin");
			adminR.save(admin1);
			adminR.save(admin2);
			//creer une agence
			Agence 	agence1=new Agence(1L,"principale","","","","",admin1,null,clients);
		//creer des agents
			String[] nomsA={"karl","Allen","Jonzdzes"};
			String[] prenomsA={"marcos","Paul","dqsn"};
			String[] usernamesA={"alain","sddallen","jonesdss"};
			String[] passwordsA={"delon","dssallen","dsjones"};
			for(int i=0;i<nomsA.length;i++){
				Agent agent=new Agent(null,null);
				agent.setPassword(passwordsA[i]);
				agent.setNom(nomsA[i]);
				agent.setPrenom(prenomsA[i]);
				agent.setUsername(usernamesA[i]);
				agent.setRole("agent");
				agents.add(agent);
				agentR.save(agent);
				
				
			}
			agence1.setAgents(agents);
			agenceR.save(agence1);
			for(Agent ag:agents){
				ag.setAgence(agence1);
				ag.setCreationAdmin(admin2);
			}
		
		//creer les comptes 
			//devise
			Devise d=new Devise(1L,"zez","Dollar","english","","","","",null,admin2,null,admin1);
			deviseR.save(d);
			
				
				
				
				Compte compte2=new Compte(1L,RandomString.make(10),"epargne",9000.0,d,null,clients.get(1),agents.get(1),null,null,null,null);
				comptes2.add(compte2);
				clients.get(1).setComptes(comptes2);
				clients.get(1).setAgence(agence1);
				clients.get(1).setCreationAgent(agents.get(1));
			clientR.save(clients.get(1));
			
			
			Compte compte3=new Compte(2L,RandomString.make(10),"epargne",4000.0,d,null,clients.get(2),agents.get(2),null,null,null,null);
			comptes3.add(compte3);
			clients.get(2).setComptes(comptes3);
			clients.get(2).setAgence(agence1);
			clients.get(2).setCreationAgent(agents.get(2));
			
		clientR.save(clients.get(2));
			
			Compte compte=new Compte(3L,RandomString.make(10),"epargne",2000.0,d,null,clients.get(0),agents.get(1),null,null,null,null);
			comptes1.add(compte);
			clients.get(0).setComptes(comptes1);
			clients.get(0).setAgence(agence1);
			clients.get(0).setCreationAgent(agents.get(0));
			
		clientR.save(clients.get(0));
		
				
			
			//Virement ENVOYES
			Virement ve1=new Virement(1L,compte,compte3,null,1200.0,1200.0);
			Virement ve2=new Virement(2L,compte,compte2,null,1500.0,1500.0);
			
			//virements RECUS
			Virement vr1=new Virement(3L,compte3,compte,null,1200.0,1200.0);
			Virement vr2=new Virement(4L,compte3,compte,null,1500.0,1500.0);
			
			
			//operation
			Operation op1=new Operation(1L,compte,null,2000.0,1999.0,"recharge",d);
			Operation op2=new Operation(2L,compte,null,2000.0,1999.0,"recharge",d);
			Operation op3=new Operation(3L,compte,null,2000.0,1999.0,"recharge",d);
			Operation op4=new Operation(4L,compte2,null,2000.0,1999.0,"recharge",d);
			Operation op5=new Operation(5L,compte3,null,2000.0,1999.0,"recharge",d);
			operations1.add(op1);
			operations1.add(op2);
			operations1.add(op3);
			operations2.add(op4);
			operations3.add(op5);
			
			virements_envoyés1.add(ve1);
			virements_envoyés1.add(ve2);
			
			
			virements_recus2.add(vr1);
			virements_recus3.add(vr2);
			
			
			
			
			
				compte.setVirementsEnvoyes(virements_envoyés1);
				compte2.setVirementsRecus(virements_recus2);
				compte3.setVirementsRecus(virements_recus3);
				compte.setOperations(operations1);
				compte2.setOperations(operations2);
				compte3.setOperations(operations3);
			operationR.save(op1);
			operationR.save(op2);
			operationR.save(op3);
			operationR.save(op4);
			operationR.save(op5);
			
			virementR.save(vr1);
			virementR.save(vr2);
			virementR.save(ve1);
			virementR.save(ve2);
			compteR.save(compte);
			compteR.save(compte3);
			compteR.save(compte2);
		
		
		
		
		


}}
