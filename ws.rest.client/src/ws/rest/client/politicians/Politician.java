package ws.rest.client.politicians;

import javax.xml.bind.annotation.XmlRootElement;

// Copy of ws.rest.politicians.data.Politician but compiled in java version 8

@XmlRootElement
public class Politician {
	private String firstName = null;
	private String lastName = null;
	private String id;
	private String sex = null;
	private String deptNumber = null;
	private String deptName = null;
	private String partyId = null;
	private String job = null;
	private String twitterId = null;
	
	public Politician() {}
	
	public Politician(String id) {
		this.id = id;
	}
	
	public Politician(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Politician(String firstName, String lastName, String id, String sex, String deptNumber, String deptName,
			String partyId, String job, String twitterId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.sex = sex;
		this.deptNumber = deptNumber;
		this.deptName = deptName;
		this.partyId = partyId;
		this.job = job;
		this.twitterId = twitterId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	@Override
	public String toString() {
		return "Politician [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", sex=" + sex
				+ ", deptNumber=" + deptNumber + ", deptName=" + deptName + ", partyId=" + partyId + ", job=" + job
				+ ", twitterId=" + twitterId + "]";
	}
	
	
}
