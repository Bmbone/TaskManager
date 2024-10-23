class Email {
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // Simulate sending an email (could be extended for real email functionality)
    public void sendEmail(String subject, String message) {
        System.out.println("Sending email to: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
