import Plan.*;
import Policy.Customer;
import Policy.Policy;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import Policy.Vehicle;
import com.sun.source.tree.Tree;

import static javax.swing.border.TitledBorder.*;

public class MainScreen extends JFrame {
    // Customization
    Font myFont = new Font("SansSerif", Font.BOLD,20);
    Color myColor = Color.GRAY;

    // Panel 1:
    JTextField subFName;
    JTextField subLName;
    JTextField subCity;
    JTextField subPhone;

    // Panel 2:
    JTextField model;
    JTextField manufacturer;
    JTextField plateNb;
    JTextField estimated;
    JRadioButton damageRadio1;
    JRadioButton damageRadio2;
    JRadioButton damageRadio3;
    JRadioButton damageRadio4;
    ButtonGroup G1;

    // Panel 3
    JCheckBox obligatoryCHKBX;
    JCheckBox allRiskCHKBX;
    JCheckBox vDamageCHKBX;
    JCheckBox dDamageCHKBX;
    JCheckBox assisCHKBX;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRisksList = new ArrayList<>();

    // Panel 4
    JRadioButton yearRadio;
    JRadioButton yearsRadio2;
    JRadioButton yearsRadio3;
    ButtonGroup G2;
    JLabel todayLBL;
    int validityYEAR =0;
    SimpleDateFormat df;
    Date currentDate;

    // Panel 5
    JTextArea risksTXT;
    JTextField searchTXT;
    Map<Integer, Customer> customerMap = new TreeMap<>();

    // Panel 7
    JTextArea policyTXT;

    // Panel 8
    JTextArea customerTXT;

    // Panel 9
    JLabel claimingTXT;
    JLabel claimingTXT2;
    JTextField claimingCustomerField;

    // Panel 10
    JLabel claimingCustomerNameLBL;
    JLabel claimingStatusLBL2;
    JTextArea claimingCustomerRisksCoveredAREA;
    JLabel claimingCustomerValidDateLBL;
    boolean cond1;
    boolean cond2;
    boolean cond3;

    // Panel 11
    JTextArea settlementArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;

    // Panel 12
    JTextArea settlementArea2;


    // Constructor
    public MainScreen(){
        CustomizePanel1();
        CustomizePanel2();
        CustomizePanel3();
        CustomizePanel4();
        CustomizePanel5();
        CustomizePanel6();
        CustomizePanel7();
        CustomizePanel8();
        CustomizePanel9();
        CustomizePanel10();
        CustomizePanel11();
        CustomizePanel12();
    }

    private void CustomizePanel1() {
        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Customer ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        p1.setBorder(titledBorder);

        JLabel fNameLBL = new JLabel("First Name: ");
        JLabel LNameLBL = new JLabel("Last Name: ");
        JLabel cityLBL = new JLabel("City");
        JLabel phoneLBL = new JLabel("Phone");

        subFName = new JTextField(); subFName.setOpaque(false);
        subLName = new JTextField(); subLName.setOpaque(false);
        subCity = new JTextField(); subCity.setOpaque(false);
        subPhone = new JTextField(); subPhone.setOpaque(false);

        p1.add(fNameLBL); p1.add(subFName); p1.add(LNameLBL);
        p1.add(subLName); p1.add(cityLBL); p1.add(subCity);
        p1.add(phoneLBL); p1.add(subPhone);
        p1.setBounds(15,15,300,200);
        p1.setLayout(new GridLayout(4,2));

        // Adding panels to JFrame
        setLayout(null);
        add(p1);
    }
    private void CustomizePanel2() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Vehicle ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p2 = new JPanel();
        p2.setBorder(titledBorder);

        // JLabel p2
        JLabel plateNbLBL = new JLabel("Plate Number: ");
        JLabel modelLBL = new JLabel("Model year: ");
        JLabel manufacturerLBL = new JLabel("Manufacturer");
        JLabel estimatedLBL = new JLabel("Estimated value");
        JLabel spaceLBL = new JLabel(" ");
        JLabel damageLBL = new JLabel("Major Damage");

        // JTextFields
        plateNb = new JTextField(); plateNb.setOpaque(false);
        model = new JTextField(); model.setOpaque(false);
        manufacturer = new JTextField(); manufacturer.setOpaque(false);
        estimated = new JTextField(); estimated.setOpaque(false);

        // RadioButtons
        damageRadio1 = new JRadioButton(); damageRadio1.setText(" Motor");
        damageRadio2 = new JRadioButton(); damageRadio2.setText(" Wheels");
        damageRadio3 = new JRadioButton(); damageRadio3.setText(" Body");
        damageRadio4 = new JRadioButton(); damageRadio4.setText(" None");

        // Adding to Radio Group
        G1 = new ButtonGroup(); G1.add(damageRadio1); G1.add(damageRadio2);
        G1.add(damageRadio3); G1.add(damageRadio4);

        // Adding components to Panel2:
        p2.add(plateNbLBL); p2.add(plateNb); p2.add(modelLBL); p2.add(model);
        p2.add(manufacturerLBL); p2.add(manufacturer); p2.add(estimatedLBL);
        p2.add(estimated); p2.add(spaceLBL); p2.add(damageLBL); p2.add(damageRadio1);
        p2.add(damageRadio2); p2.add(damageRadio3); p2.add(damageRadio4);

        // Customize panel2
        p2.setBounds(15,250,300,500);
        p2.setLayout(new GridLayout(14,1));
        setLayout(null);
        add(p2);
    }
    private void CustomizePanel3() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Plan ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p3 = new JPanel();
        p3.setBorder(titledBorder);
        p3.setBounds(330,15,300,200);
        p3.setLayout(new GridLayout(6,1));

        JLabel packageLBL = new JLabel("Please select your plan");

        // Checkbox
        obligatoryCHKBX = new JCheckBox("Obligatory");
        allRiskCHKBX = new JCheckBox("All Risk");
        vDamageCHKBX = new JCheckBox("Vehicle Damage");
        dDamageCHKBX = new JCheckBox("Driver Damage");
        assisCHKBX = new JCheckBox("Assistance");

        // Get all risks covered by plan
        GetRisksCoveredByPlan();

        // Adding components to panel3
        p3.add(packageLBL); p3.add(obligatoryCHKBX); p3.add(allRiskCHKBX);
        p3.add(vDamageCHKBX); p3.add(dDamageCHKBX); p3.add(assisCHKBX);
        add(p3);
    }
    private void CustomizePanel4() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Validity Period ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p4 = new JPanel();
        p4.setBorder(titledBorder);
        p4.setBounds(330,250,300,250);
        p4.setLayout(new GridLayout(6,1));

        // Radio Buttons
        JLabel space2 = new JLabel(" "); space2.setOpaque(false);
        yearRadio = new JRadioButton(); yearRadio.setText(" 1 Year");
        yearsRadio2 = new JRadioButton(); yearsRadio2.setText(" 2 Years");
        yearsRadio3 = new JRadioButton(); yearsRadio3.setText(" 3 Years");

        // Radio Buttons Event

        yearRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 1;
            }
        });

        yearsRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 2;
            }
        });

        yearsRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYEAR = 3;
            }
        });

        // Buttons Groups

        G2 = new ButtonGroup(); G2.add(yearRadio);
        G2.add(yearsRadio2); G2.add(yearsRadio3);

        // Time and date
        todayLBL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayLBL.setText("Today: " + df.format(currentDate));
        todayLBL.setOpaque(false);

        Font font = todayLBL.getFont();
        float size = font.getSize() + 3.0f;
        todayLBL.setFont( font.deriveFont(size) );

        // Adding all components to Panel4
        p4.add(space2); p4.add(space2); p4.add(todayLBL); p4.add(space2);
        p4.add(yearRadio); p4.add(yearsRadio2); p4.add(yearsRadio3);

        // Adding Panel4 to JFrame
        add(p4);
    }
    private void CustomizePanel5() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Actions ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p5 = new JPanel();
        p5.setBounds(330,520,300,230);
        p5.setBorder(titledBorder);
        p5.setLayout(new GridLayout(7,1));

        JButton saveBTN = new JButton("Save Customer");
        JButton showBTN = new JButton("Show Plan Details");
        JButton loadBTN = new JButton("Load Customer");
        JButton newBTN = new JButton("New Customer");

        searchTXT = new JTextField("Enter Car Plate Number");
        searchTXT.setOpaque(false);

        // Create Action Listeners

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "";
                for (int i = 0; i<coveredRisksList.size(); i++){
                    str += coveredRisksList.get(i) + "\n";
                }
                risksTXT.setText(str);

                try {
                    policyTXT.setText(GetPolicyData().toString());
                    DisplayPaymentsOfPolicy();
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    SaveCustomerMapToDisk();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });

        JLabel space3 = new JLabel(" ");
        space3.setOpaque(false);

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchCustomerByMobileNB();
            }
        });

        JLabel space4 = new JLabel(" ");
        space4.setOpaque(false);

        JLabel space5 = new JLabel(" ");
        space5.setOpaque(false);

        JLabel space6 = new JLabel(" ");
        space6.setOpaque(false);

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewCustomer();
            }
        });

        p5.add(space6);
        p5.add(showBTN);
        p5.add(saveBTN);
        p5.add(newBTN);
        p5.add(space5);
        p5.add(searchTXT);
        p5.add(loadBTN);
        add(p5);

    }
    private void CustomizePanel6() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Cover Risks ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);
        JPanel p6 = new JPanel();
        p6.setBorder(titledBorder);
        p6.setBounds(645,15,300,200);

        risksTXT = new JTextArea(7,1);
        risksTXT.setEditable(false); risksTXT.setOpaque(false);
        risksTXT.setLineWrap(true);

        // Font
        Font font = risksTXT.getFont();
        float size = font.getSize() + 3.0f;
        risksTXT.setFont(font.deriveFont((size)));

        p6.add(risksTXT); p6.setLayout(new GridLayout(1,1));
        add(p6); // Adding p6 to the JFrame...




    }
    private void CustomizePanel7() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Policy Details ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);
        JPanel p7 = new JPanel();
        p7.setBounds(645,250,300,250);
        p7.setBorder(titledBorder);
        p7.setLayout(new GridLayout(6,1));

        policyTXT = new JTextArea(20,1);
        policyTXT.setEditable(false);
        policyTXT.setOpaque(false);
        policyTXT.setLineWrap(true);

        Font font = policyTXT.getFont();
        float size = font.getSize() + 3.0f;
        policyTXT.setFont(font.deriveFont(size));

        p7.add(policyTXT); p7.setLayout(new GridLayout(1,1));
        add(p7); // Adding panel to JFrame
    }
    private void CustomizePanel8() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Customer Details ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p8 = new JPanel();
        p8.setBorder(titledBorder);
        p8.setBounds(645,520,300,230);
        p8.setLayout(new GridLayout(6,1));

        customerTXT = new JTextArea(20,1);
        customerTXT.setEditable(false);
        customerTXT.setOpaque(false);
        customerTXT.setLineWrap(true);

        // Increase the size of font in the text area
        Font font = customerTXT.getFont();
        float size = font.getSize() + 3.0f;
        customerTXT.setFont(font.deriveFont(size));

        p8.add(customerTXT); p8.setLayout(new GridLayout(1,1));
        add(p8);
    }
    private void CustomizePanel9() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Claims ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p9 = new JPanel();
        p9.setBorder(titledBorder);
        p9.setBounds(960,15,300,485);

        claimingTXT = new JLabel("Enter plate number for the claiming Customer");
        JLabel space9 = new JLabel("                                                    ");
        claimingTXT2 = new JLabel("Selected the type of Damage or Assistance Needed");

        claimingCustomerField = new JTextField();
        claimingCustomerField.setPreferredSize(new Dimension(250,30));
        claimingCustomerField.setOpaque(false);

        String[] items = { "Fire", "Robbery", "Third Party Damage",
                "Vehicle Damage", "Driver Damage", "Transport",
                "Car Replacement"};

        final JList claimingList = new JList(items);
        claimingList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        claimingList.setOpaque(false);
        claimingList.setPreferredSize(new Dimension(250,150));

        JButton searchClaimer = new JButton("Search Customer");
        List<String> coveredRisksByUserLIST = new ArrayList<>();

        searchClaimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cond1 = false;  // Customer is registered before in our database
                cond2 = false;  // Is the customer's policy cover the claimed risk?
                cond3 = false;  // Is the policy date valid?

                try{
                    coveredRisksByUserLIST.clear();
                    Customer c = ClaimsSearchCustomerByMobileNb();
                    claimingCustomerNameLBL.setText("Claiming Customer: "
                            + c.getFirstName() + " " + c.getLastName());

                    cond1 = true;
                    String str7 = "";
                    for (int i = 0; i<c.getPolicy().getRisksCoveredLIST().size(); i++){
                        str7 += c.getPolicy().getRisksCoveredLIST().get(i) + " \n";
                        coveredRisksByUserLIST.add(c.getPolicy().getRisksCoveredLIST().get(i));
                    }
                    LocalDate v_validityofPolicy = c.getPolicy().getPolicyDate();
                    int v_policyValidityYears = c.getPolicy().getValidityYear();
                    v_validityofPolicy = v_validityofPolicy.plusYears(v_policyValidityYears);

                    CheckPolicyValidity(v_validityofPolicy);
                    claimingCustomerRisksCoveredAREA.setText("Covered Risks by Customer plan:\n" + str7);
                    claimingCustomerValidDateLBL.setText("Date Validity of Policy: "
                            + v_validityofPolicy+ " ||" + CheckPolicyValidity(v_validityofPolicy));

                    if (c.getPolicy().getRisksCoveredLIST().size() >=5){
                        // If the user has an all-risk plan
                        cond2 = true;
                    }

                } catch (Exception ee){
                    claimingCustomerNameLBL.setText("Claiming Customer: Not Found");
                }
            }
        });

        JButton confirmClaimBTN = new JButton(" Confirm Claim");

        confirmClaimBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the index of all the selected items
                int[] selectedIx = claimingList.getSelectedIndices();
                List<String> claimed_list = new ArrayList<>();

                if (claimingList.getSelectedIndex() != -1){
                    for (int i = 0; i<selectedIx.length; i++){
                        String k = "" + claimingList.getModel().getElementAt(selectedIx[i]) + " ";
                        claimed_list.add(""+ claimingList.getModel().getElementAt(selectedIx[i]));
                        System.out.println("" + k);
                    }
                }

                // Check for the included risks...
                if (cond2 == false){
                    cond2 = claimed_list.containsAll(coveredRisksByUserLIST);
                }

                // Check for claim validity to add the claim
                // to the customer, claims map on other file myfile2

                ClaimIsValid();

                // Display settlements
                Customer c = ClaimsSearchCustomerByMobileNb();
                if (ClaimIsValid()){
                    int claims_nb = claimed_list.size();
                    if (claimed_list.contains("Fire")){
                        settlementArea2.setText("Fire Department: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.25 + " $");

                    }else if (claimed_list.contains("Robbery")){
                        settlementArea2.setText("ProSec Company: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.5 + " $" +
                                "Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*1 + " $");

                    }else if  (claimed_list.contains("Third Party Damage")){
                        settlementArea2.setText("Driver in other Car: " + 2000 + "$");

                    }else if (claimed_list.contains("Vehicle Damage")){
                        settlementArea2.setText("Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*1+ " $");

                    }else if (claimed_list.contains("Driver Damage")) {
                        settlementArea2.setText("Pay for Customer: " +
                                c.getPolicy().getVehicle().getEstimatedValue()*10+ " $");

                    }else if (claimed_list.contains("Transport")){
                        settlementArea2.setText("Transport Company " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.5+ " $");

                    }else if (claimed_list.contains("Car Replacement")){
                        settlementArea2.setText("Car Rental Company " +
                                c.getPolicy().getVehicle().getEstimatedValue()*0.2+ " $");

                    }else if (claims_nb > 2){
                        settlementArea2.setText("Driver "
                                + c.getPolicy().getVehicle().getEstimatedValue()*4+ " $"+
                                "Hospital " + c.getPolicy().getVehicle().getEstimatedValue()*4
                                + " $ "+

                                "Car Rental Company "
                                + c.getPolicy().getVehicle().getEstimatedValue()*0.2 + " $ "+
                                "Third Party Driver " +
                                c.getPolicy().getVehicle().getEstimatedValue()*2
                        );

                    }else{

                    }
                }
            }
        });

        p9.add(claimingTXT); p9.add(claimingCustomerField);
        p9.add(searchClaimer); p9.add(space9); p9.add(claimingTXT2);
        p9.add(claimingList); p9.add(confirmClaimBTN); add(p9);
    }
    private void CustomizePanel10() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Claim Status ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p10 = new JPanel();
        p10.setBorder(titledBorder);
        p10.setBounds(960,520,300,230);
        p10.setLayout(new GridLayout(4,1));

        // JLabels
        claimingCustomerNameLBL = new JLabel("Claiming Customer: ");
        claimingCustomerValidDateLBL = new JLabel("Date Validity of Policy ");
        claimingStatusLBL2 = new JLabel("Claiming Status: ");

        // JTextArea
        claimingCustomerRisksCoveredAREA = new JTextArea();
        JScrollPane pictureScrollPane = new JScrollPane(claimingCustomerRisksCoveredAREA);
        claimingCustomerRisksCoveredAREA.setOpaque(false);

        p10.add(claimingCustomerNameLBL); p10.add(claimingCustomerValidDateLBL);
        p10.add(pictureScrollPane); p10.add(claimingStatusLBL2);
        add(p10);
    }
    private void CustomizePanel11() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Payments ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p11 = new JPanel();
        p11.setBorder(titledBorder);
        p11.setBounds(1275,15,250,230);
        p11.setLayout(new GridLayout(2,1));

        settlementArea = new JTextArea();
        settlementArea.setOpaque(false);

        // Increase the size in the JTextArea
        Font font = settlementArea.getFont();
        float size = font.getSize() + 4.0f;
        settlementArea.setFont(font.deriveFont(size));

        p11.add(settlementArea); add(p11);
    }
    private void CustomizePanel12() {
        TitledBorder titledBorder = BorderFactory.createTitledBorder
                (BorderFactory.createLineBorder(Color.GRAY, 1),
                        " Settlements ", CENTER,
                        DEFAULT_POSITION,myFont,myColor);

        JPanel p12 = new JPanel();
        p12.setBorder(titledBorder);
        p12.setBounds(1275,250,250,500);
        p12.setLayout(new GridLayout());

        settlementArea2 = new JTextArea();
        settlementArea2.setOpaque(false);
        p12.add(settlementArea2);

        Font font = settlementArea2.getFont();
        float size = font.getSize() + 4.0f;

        add(p12);
    }

                            /***** METHODS *****/

    // Get Customer Data
    public Customer GetCustomerData() throws ParseException{
        Customer customer = new Customer(
                subFName.getText(),
                subLName.getText(),
                subCity.getText(),
                Integer.parseInt(subPhone.getText()),
                GetPolicyData()
        );
        return customer;
    }

    // Vehicle Data
    public Vehicle GetVehicle() throws ParseException{
        Vehicle vehicle = new Vehicle(
                Integer.parseInt(plateNb.getText()),
                Integer.parseInt(model.getText()),
                manufacturer.getText(),
                Integer.parseInt(estimated.getText()),
                GetDamageState()
        );
        return vehicle;
    }

    // Get Policy Data
    private Policy GetPolicyData() throws ParseException {
        currentDate = new Date();
        LocalDate now = LocalDate.now();
        Policy policy = new Policy(
                GetVehicle(),
                coveredRisksList,
                premiumRisksList,
                coverageRisksList,
                ceilingRisksList,
                validityYEAR,
                now
        );
        return policy;
    }

    // Get Damage Data
    private int GetDamageState() {
        if (damageRadio1.isSelected()){
            return 1;
        } else if (damageRadio2.isSelected()){
            return 2;
        } else if (damageRadio3.isSelected()) {
            return 3;
        } else return 0;
    }

    // Get Plan Details
    public void GetRisksCoveredByPlan() {
        AllRisk allRisk = new AllRisk();
        ObligatoryRisk obligatoryRisk = new ObligatoryRisk();

        allRiskCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dDamageCHKBX.setEnabled(false);
                vDamageCHKBX.setEnabled(false);
                assisCHKBX.setEnabled(false);
                obligatoryCHKBX.setEnabled(false);

                // Adding risk details to an array
                for (int i=0; i<allRisk.allRiskCovered.length; i++){
                    coveredRisksList.add(allRisk.allRiskCovered[i]);
                }
                premiumRisksList.add(allRisk.getPremium());
                coverageRisksList.add(allRisk.getCoverage());
                ceilingRisksList.add(allRisk.getCeiling());
                    }
                });

        obligatoryCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coveredRisksList.add(obligatoryRisk.obligatoryRiskCovered[0]);
                premiumRisksList.add(obligatoryRisk.getPremium());
                coverageRisksList.add(obligatoryRisk.getCoverage());
                ceilingRisksList.add(obligatoryRisk.getCeiling());
            }
        });

        vDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehicleRisk vehicleRisk = new VehicleRisk();

                // Adding Risk Details to arrays
                coveredRisksList.add(vehicleRisk.VehicleRiskCovered[0]);
                premiumRisksList.add(vehicleRisk.getPremium());
                coverageRisksList.add(vehicleRisk.getCoverage());
                ceilingRisksList.add(vehicleRisk.getCeiling());
            }
        });

        dDamageCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverRisk driverRisk = new DriverRisk();

                coveredRisksList.add(driverRisk.driverRiskCovered[0]);
                premiumRisksList.add(driverRisk.getPremium());
                coverageRisksList.add(driverRisk.getCoverage());
                ceilingRisksList.add(driverRisk.getCeiling());
            }
        });

        assisCHKBX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssistanceRisk assistanceRisk = new AssistanceRisk();

                // Adding Risk to Details to an array
                for (int i =0; i<assistanceRisk.assistanceRiskCovered.length; i++){
                    coveredRisksList.add(assistanceRisk.assistanceRiskCovered[i]);
                }

                premiumRisksList.add(assistanceRisk.getPremium());
                coverageRisksList.add(assistanceRisk.getCoverage());
                ceilingRisksList.add(assistanceRisk.getCeiling());
            }
        });
    }

    // Save data to disk
    public void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException, ParseException {
        File file = new File("D:/file.dat");
        int platenumr = Integer.parseInt(plateNb.getText());
        if (!file.exists()){
            // Create new file
            System.out.println("Not existed...");
            file.createNewFile();
            SaveCustomerMapToNewFile(platenumr, file);
        } else {
            // File exist:
            TreeMap<Integer, Customer> newMapToSave = new TreeMap<>();
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();

            // Get Old Map
            for (Map.Entry<Integer, Customer> m : mapInFile.entrySet()){
                newMapToSave.put(m.getKey(), m.getValue());
            }

            // Updating the map: Adding new customer to map
            newMapToSave.put(platenumr, GetCustomerData());

            // Saving the updates to file
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(newMapToSave);
            oos.flush();
            oos.close();
        }

    }

    private void SaveCustomerMapToNewFile(int platenumr, File file) throws ParseException, IOException {
        TreeMap<Integer, Customer> newMapToSave = new TreeMap<>();

        // Adding new customer to map
        newMapToSave.put(platenumr, GetCustomerData());
        OutputStream os  = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMapToSave);
        oos.flush();
        oos.close();
    }

    // Resetting Fields to empty...
    private void NewCustomer(){
        coverageRisksList.clear(); coveredRisksList.clear();
        premiumRisksList.clear(); ceilingRisksList.clear();
        cond1 = false; cond2 = false; cond3 = false;

        // Set TextFields to empty
        subFName.setText(""); subLName.setText(""); subCity.setText("");
        subPhone.setText(""); plateNb.setText(""); model.setText("");
        manufacturer.setText(""); estimated.setText("");

        // Set RadioButtons selection to null
        G1.clearSelection(); G2.clearSelection();

        // Reset CheckBoxes
        obligatoryCHKBX.setSelected(false);
        allRiskCHKBX.setSelected(false);
        vDamageCHKBX.setSelected(false);
        dDamageCHKBX.setSelected(false);
        assisCHKBX.setSelected(false);

        dDamageCHKBX.setEnabled(true);
        vDamageCHKBX.setEnabled(true);
        assisCHKBX.setEnabled(true);
        obligatoryCHKBX.setEnabled(true);
    }

    private void SearchCustomerByMobileNB(){
        File file = new File("D:/file.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();

            Customer c_finded = mapInFile.get(Integer.parseInt(searchTXT.getText()));
            customerTXT.setText(c_finded.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Customer ClaimsSearchCustomerByMobileNb(){
        Customer customer = new Customer();
        File file = new File("D:/file.dat");

        try{
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<Integer, Customer> mapInFile = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();

            customer = mapInFile.get(Integer.parseInt(claimingCustomerField.getText()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    private boolean CheckPolicyValidity(LocalDate v_validityofPolicy){
        LocalDate now = LocalDate.now(); // getting the current date
        if (now.isBefore(v_validityofPolicy)){
            cond3 = true;
            return true;
        } else {
            cond3 = false;
            return false;
        }
    }

    private boolean ClaimIsValid(){
        if (cond1 == true && cond2 == true && cond3 == true){
            claimingStatusLBL2.setText("Claiming Status: You can register the Claim");
            return true;
        } else {
            claimingStatusLBL2.setText("Claiming Status: Not Able to register the claim ");
            return false;
        }
    }

    private void DisplayPaymentsOfPolicy(){
        for (int i = 0; i<premiumRisksList.size(); i++){
            totalPremium += premiumRisksList.get(i);
            totalCoverage += coverageRisksList.get(i);
            totalCeiling += ceilingRisksList.get(i);
        }

        settlementArea.setText(
                "Total Premium: " +
                        totalPremium*Integer.parseInt(estimated.getText())
                        + "$  \n " + "Risk Coverage: " +
                        totalCoverage*Integer.parseInt(estimated.getText())*10
                + " $ \n " + "Max Ceiling: " +
                        totalCeiling*Integer.parseInt(estimated.getText())
                        + 100000 + " $ \n"
        );
    }

    public static void main (String[] args){
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setTitle("Insurance Company System");
        mainScreen.setBounds(0,0,192,1080);
    }
}
