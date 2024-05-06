class Guest {
    private String name;
    private String contactDetails;
    private String membershipInfo; // You can extend this as per your requirements

    public Guest(String name, String contactDetails, String membershipInfo) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.membershipInfo = membershipInfo;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getMembershipInfo() {
        return membershipInfo;
    }

    public void setMembershipInfo(String membershipInfo) {
        this.membershipInfo = membershipInfo;
    }
}