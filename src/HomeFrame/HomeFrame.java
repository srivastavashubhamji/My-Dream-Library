package HomeFrame;
// This is the main File to Run....
import java.awt.Color; 
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.sql.*;

// when selecting 'itext jarfile', Unchecked below 'Build Path to Classpath' setting then clicked 'Ok';
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Phrase;
import java.io.File;
import java.io.FileOutputStream;

// Constructor ... which sets the default Settings for the Forms, Labels, Buttons and other Components...
public class HomeFrame extends javax.swing.JFrame {
    
    private JPanel[] allPanels;
    private JTextField[] allBkAddTxt;
    private String[] allPanelsNames;
    private java.util.ArrayList<String> listBkRet;
    private int isMemShipExpUpdated;
//    private String lastPanelName;

    public HomeFrame() {
        initComponents();
        setBounds(new java.awt.Rectangle(170, 0, 1000, 700));
        allPanels = new JPanel[]{pnlLogo, pnlBkAdd, pnlBkIssue, pnlBkShow, pnlBkEdit, pnlBkEditNow, pnlBkDel,
            pnlBkDel_B, pnlBkDelNow, pnlBkDel_D, pnlBkDel_E, pnlMAdd, pnlBkRet, pnlReport};
        allPanelsNames = new String[]{"pnlLogo", "pnlBkAdd", "pnlBkIssue", "pnlBkShow", "pnlBkEdit", "pnlBkEditNow",
            "pnlBkDel", "pnlBkDel_B", "pnlBkDelNow", "pnlBkDel_D", "pnlBkDel_E", "pnlMAdd", "pnlBkRet", "pnlReport"};
        // call showOnlyPanel("pnlBkAdd"); to perform as fun_name
        setPanels();    // All panels Bounds = Parent Panels Bounds and All panels .setVisible = false;

        allBkAddTxt = new JTextField[]{txtBkName, txtBkType, txtBkRack, txtBkAuth1, txtBkPub, txtBkQty,
            txtBkPrice, txtBkPages, txtBkAuth2, txtBkAbout};

        pnlParentBtns.setVisible(true);
        pnlParent.setVisible(true);
        pnlLogo.setVisible(true);

        // ButtonGroup and RadioButtons used in Delete Book Panel
        ButtonGroup bg = new ButtonGroup();
        bg.add(lblBkDelE_rbtnMem);
        bg.add(lblBkDelE_rbtnOth);
        //bounds of pnlBkDelE_m      : X=762, Y=451, rg.height=0 ,rg.width=0		// Panel
        // These below 4 line's Code Setting bounds of Panels are of Delete_Book_Panel's Sub Panel
        pnlBkDelE_m.setBounds(762, 451, 0, 0);
        pnlBkDelE_m.setVisible(false);
        pnlBkDelE_o.setBounds(762, 451, 0, 0);
        pnlBkDelE_o.setVisible(false);

        // Issue Book SubPanels
        pnlBkI_A.setBounds(79, 119, 750, 303);
        pnlBkI_A.setVisible(false);
        pnlBkI_B.setBounds(79, 119, 750, 303);
        pnlBkI_B.setVisible(false);
        pnlBkI_C.setBounds(0, 0, 899, 550);
        pnlBkI_C.setVisible(false);
        pnlBkI_D.setBounds(79, 106, 750, 337);
        pnlBkI_D.setVisible(false);

        // Return Book SubPanels 
        listBkRet = null;
        pnlBk_R_A.setBounds(79, 106, 750, 337);
        pnlBk_R_A.setVisible(false);
        pnlBk_R_B.setBounds(79, 56, 750, 400);
        pnlBk_R_B.setVisible(false);
        pnlBk_R_C.setBounds(0, 0, 899, 550);
        pnlBk_R_C.setVisible(false);

//        pnlBkR_C.getBounds( x,y,w,h ) : ( 147,190,605,196 )
        pnlBkR_C_sub1.setBounds(147, 190, 605, 196);
        pnlBkR_C_sub1.setVisible(false);
        pnlBkR_C_sub2.setBounds(152, 190, 590, 196);
        pnlBkR_C_sub2.setVisible(false);

//      While Return Book : in SubPnl_C -: Increment / Decrement Last Date 
        ButtonGroup bgForBkRet_C = new ButtonGroup();
        bgForBkRet_C.add(radioR_C_inc);
        bgForBkRet_C.add(radioR_C_dec);

        isMemShipExpUpdated = 0;  // -1 Represents check_UpdateExpiryOfMemShip() Didn't Executed completely Even Once
        isMemShipExpUpdated = check_UpdateExpiryOfMem_ship();
    }
//      First method i.e. set to call for creation and initialization of all Components ...
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlParentBtns = new javax.swing.JPanel();
        btnBkAdd = new javax.swing.JButton();
        btnBkRemove = new javax.swing.JButton();
        btnBkShow = new javax.swing.JButton();
        btnBkIssue = new javax.swing.JButton();
        btnBkReturn = new javax.swing.JButton();
        btnMemRemove = new javax.swing.JButton();
        btnMemShow = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnBkAdvEdit = new javax.swing.JButton();
        btnBkFind = new javax.swing.JButton();
        btnBkAdvSer = new javax.swing.JButton();
        btnMemAdd = new javax.swing.JButton();
        pnlParent = new javax.swing.JPanel();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlBkAdd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBkName = new javax.swing.JTextField();
        txtBkType = new javax.swing.JTextField();
        txtBkRack = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBkQty = new javax.swing.JTextField();
        txtBkPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBkPages = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBkAuth1 = new javax.swing.JTextField();
        txtBkAuth2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBkPub = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBkAbout = new javax.swing.JTextField();
        btnBkAddSave = new javax.swing.JButton();
        btnBkAddBack = new javax.swing.JButton();
        lblBkErrSucc = new javax.swing.JLabel();
        pnlBkIssue = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        pnlBkI_A = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        lblBkI_A_Data = new javax.swing.JTextField();
        btnBkD_back4 = new javax.swing.JButton();
        pnlBkI_A_sub1 = new javax.swing.JButton();
        lblBkI_A_err = new javax.swing.JLabel();
        btnBkI_A_show = new javax.swing.JButton();
        pnlBkI_B = new javax.swing.JPanel();
        btnBkShow_Go1 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        txtBkI_B_data = new javax.swing.JTextField();
        btnBkD_back3 = new javax.swing.JButton();
        pnlBkI_B_chgMem = new javax.swing.JButton();
        txtBkI_B_mem = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lblBkI_B_err = new javax.swing.JLabel();
        txtBkI_B_mNm = new javax.swing.JLabel();
        txtBkI_B_doi = new javax.swing.JLabel();
        txtBkI_B_mId = new javax.swing.JLabel();
        comboBkI_B = new javax.swing.JComboBox<>();
        pnlBkI_C = new javax.swing.JPanel();
        btnBkShow_Go2 = new javax.swing.JButton();
        lblBk_I_C_mDoj = new javax.swing.JTextField();
        lblBk_I_C_mId = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        lblBkI_C = new javax.swing.JLabel();
        btnBkD_back5 = new javax.swing.JButton();
        pnlBkI_B_chgMem1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listBkShow1 = new javax.swing.JList<>();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        lblBk_I_C_bId = new javax.swing.JLabel();
        lblBk_I_C_bName = new javax.swing.JLabel();
        lblBk_I_C_bAuth = new javax.swing.JLabel();
        lblBk_I_C_bType = new javax.swing.JLabel();
        lblBk_I_C_bAvb = new javax.swing.JLabel();
        lblBk_I_C_mName = new javax.swing.JLabel();
        pnlBkI_D = new javax.swing.JPanel();
        btnBkShow_Go3 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        lblMIss_mName2 = new javax.swing.JLabel();
        lblMIss_mName3 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lblMIss_mName4 = new javax.swing.JLabel();
        lblMIss_mName5 = new javax.swing.JLabel();
        btnBkD_back6 = new javax.swing.JButton();
        pnlBkI_B_chgMem2 = new javax.swing.JButton();
        lblMIss_mName6 = new javax.swing.JLabel();
        lblMIss_mName7 = new javax.swing.JLabel();
        lblMIss_mName8 = new javax.swing.JLabel();
        lblBk_I_D_bIssDt = new javax.swing.JLabel();
        lblBk_I_D_bRetDt = new javax.swing.JLabel();
        lblBk_I_D_bNm2 = new javax.swing.JLabel();
        lblMIss_mName9 = new javax.swing.JLabel();
        lblBk_I_D_mNm2 = new javax.swing.JLabel();
        lblBk_I_D_mId = new javax.swing.JLabel();
        lblBk_I_D_mNm = new javax.swing.JLabel();
        lblBk_I_D_mAuth = new javax.swing.JLabel();
        lblBk_I_D_bId = new javax.swing.JLabel();
        lblBk_I_D_bNm = new javax.swing.JLabel();
        lblBk_I_D_bType = new javax.swing.JLabel();
        lblBkI_D_err = new javax.swing.JLabel();
        pnlBkShow = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBkShow = new javax.swing.JList<>();
        lblBkShowErr = new javax.swing.JLabel();
        lblBkShowTotalBk = new javax.swing.JLabel();
        lblBkShowNBks = new javax.swing.JLabel();
        lblBkShowBkQty = new javax.swing.JLabel();
        lblBkShowNBkQty = new javax.swing.JLabel();
        lblBkShowBkStsA = new javax.swing.JLabel();
        lblBkShowNBkStsA = new javax.swing.JLabel();
        lblBkShowBkStsI = new javax.swing.JLabel();
        lblBkShowNBkStsI = new javax.swing.JLabel();
        lblBkShowBkStsR = new javax.swing.JLabel();
        lblBkShowNBkStsR = new javax.swing.JLabel();
        pnlBkEdit = new javax.swing.JPanel();
        pnlBkE_Input = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtBkEdit_find = new javax.swing.JTextField();
        btnBkShow_Go = new javax.swing.JButton();
        btnBkD_back2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblBkEditErr = new javax.swing.JLabel();
        pnlBkEditNow = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblBkEditNowErr = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtBkE_name = new javax.swing.JTextField();
        txtBkE_type = new javax.swing.JTextField();
        txtBkE_rack = new javax.swing.JTextField();
        txtBkE_auth1 = new javax.swing.JTextField();
        txtBkE_auth2 = new javax.swing.JTextField();
        txtBkE_pub = new javax.swing.JTextField();
        txtBkE_about = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtBkE_qty = new javax.swing.JTextField();
        txtBkE_price = new javax.swing.JTextField();
        txtBkE_pages = new javax.swing.JTextField();
        btnBkE_back = new javax.swing.JButton();
        btnBkE_update = new javax.swing.JButton();
        btnBkE_showBks = new javax.swing.JButton();
        lblBkE_id = new javax.swing.JLabel();
        pnlBkDel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        pnlBkE_Input1 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtBkD_data = new javax.swing.JTextField();
        btnBkD_del = new javax.swing.JButton();
        btnBkD_back = new javax.swing.JButton();
        lblBkD_errMsg = new javax.swing.JLabel();
        pnlBkDel_B = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listBkDel_B = new javax.swing.JList<>();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        lblBk_D_B_bId = new javax.swing.JLabel();
        lblBk_D_B_bName = new javax.swing.JLabel();
        lblBk_D_B_bAuth = new javax.swing.JLabel();
        lblBk_D_B_bType = new javax.swing.JLabel();
        lblBk_D_B_bAvb = new javax.swing.JLabel();
        btnBkD_back10 = new javax.swing.JButton();
        pnlBkI_B_chgMem5 = new javax.swing.JButton();
        btnBkShow_Go4 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        pnlBkDelNow = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnBkDel_E_back = new javax.swing.JButton();
        btnBkDel_E = new javax.swing.JButton();
        lblBkDel_E_Err = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lblBkDelE_Btype = new javax.swing.JLabel();
        lblBkDelE_Bname = new javax.swing.JLabel();
        lblBkDelE_auth = new javax.swing.JLabel();
        lblBkDelE_qty = new javax.swing.JLabel();
        lblBkDelE_nIss = new javax.swing.JLabel();
        lblBkDelE_nAva = new javax.swing.JLabel();
        lblBkDelE_nRep = new javax.swing.JLabel();
        lblBkDelE_nDes = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lblBkDelE_rbtnMem = new javax.swing.JRadioButton();
        lblBkDelE_rbtnOth = new javax.swing.JRadioButton();
        pnlBkDelE_m = new javax.swing.JPanel();
        lblBkDel_E_mid = new javax.swing.JLabel();
        txtBkDel_E_mid = new javax.swing.JTextField();
        pnlBkDelE_o = new javax.swing.JPanel();
        lblBkDel_E_mid1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaBkDel_E = new javax.swing.JTextArea();
        lblBkDelE_Bid = new javax.swing.JLabel();
        pnlBkDel_D = new javax.swing.JPanel();
        pnlBkE_Input2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listBkDel_D = new javax.swing.JList<>();
        btnBkDel_D_Submit = new javax.swing.JButton();
        btnBkDel_D_Cancel = new javax.swing.JButton();
        btnBkDel_D_Back = new javax.swing.JButton();
        lblMetaInfoInBkDel_D = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        pnlBkDel_E = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        lblBk_R_B_mId1 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        lblBk_R_B_bId1 = new javax.swing.JLabel();
        lblMIss_mName26 = new javax.swing.JLabel();
        lblBk_R_B_mNm1 = new javax.swing.JLabel();
        lblMIss_mName27 = new javax.swing.JLabel();
        lblBk_R_B_bNm1 = new javax.swing.JLabel();
        lblMIss_mName28 = new javax.swing.JLabel();
        lblBk_R_B_mType1 = new javax.swing.JLabel();
        lblMIss_mName29 = new javax.swing.JLabel();
        lblBk_R_B_bAuth1 = new javax.swing.JLabel();
        lblMIss_mName30 = new javax.swing.JLabel();
        lblBk_R_B_bIssDt1 = new javax.swing.JLabel();
        lblMIss_mName31 = new javax.swing.JLabel();
        lblBk_R_B_bLastDt2 = new javax.swing.JLabel();
        lblMIss_mName32 = new javax.swing.JLabel();
        lblBk_R_B_bNm3 = new javax.swing.JLabel();
        lblMIss_mName33 = new javax.swing.JLabel();
        lblBk_I_D_mNm4 = new javax.swing.JLabel();
        btnBack_pnlBkDel_E = new javax.swing.JButton();
        btnCancel_pnlBkDel_E = new javax.swing.JButton();
        btnSubmit_pnlBkDel_E = new javax.swing.JButton();
        lblBkR_B_err1 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        pnlBkR_C_sub3 = new javax.swing.JPanel();
        lblFineInfo1 = new javax.swing.JLabel();
        lblFineCalc1 = new javax.swing.JLabel();
        btnRetBkRecv1 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        pnlMAdd = new javax.swing.JPanel();
        btnMAdd_submit = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtMAdd_doj = new javax.swing.JTextField();
        txtMAdd_Name = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtMAdd_Ph1 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtMAdd_Ph2 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtMAdd_Addr = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        chkMAdd_iss = new javax.swing.JCheckBox();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        comboMAdd = new javax.swing.JComboBox<>();
        btnMAdd_bk = new javax.swing.JButton();
        lblMAddErr = new javax.swing.JLabel();
        btnMAdd_reset = new javax.swing.JButton();
        txtMAdd_Class = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtMAdd_Rno = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        pnlBkRet = new javax.swing.JPanel();
        lblRetBook = new javax.swing.JLabel();
        pnlBk_R_A = new javax.swing.JPanel();
        pnlBkI_A_sub2 = new javax.swing.JButton();
        lblBkR_A_err = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        lblBkR_A_Data = new javax.swing.JTextField();
        btnBkD_back7 = new javax.swing.JButton();
        pnlBk_R_B = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        lblBk_R_B_mId = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        lblBk_R_B_bId = new javax.swing.JLabel();
        lblMIss_mName10 = new javax.swing.JLabel();
        lblBk_R_B_mNm = new javax.swing.JLabel();
        lblMIss_mName11 = new javax.swing.JLabel();
        lblBk_R_B_bNm = new javax.swing.JLabel();
        lblMIss_mName12 = new javax.swing.JLabel();
        lblBk_R_B_mType = new javax.swing.JLabel();
        lblMIss_mName13 = new javax.swing.JLabel();
        lblBk_R_B_bAuth = new javax.swing.JLabel();
        btnBkD_back8 = new javax.swing.JButton();
        pnlBkI_B_chgMem3 = new javax.swing.JButton();
        pnlBkI_B_sub1 = new javax.swing.JButton();
        lblMIss_mName14 = new javax.swing.JLabel();
        lblBk_R_B_bIssDt = new javax.swing.JLabel();
        lblMIss_mName15 = new javax.swing.JLabel();
        lblBk_R_B_bLastDt = new javax.swing.JLabel();
        lblMIss_mName16 = new javax.swing.JLabel();
        lblBk_R_B_bNm2 = new javax.swing.JLabel();
        lblMIss_mName17 = new javax.swing.JLabel();
        lblBk_I_D_mNm3 = new javax.swing.JLabel();
        lblBkR_B_err = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listBkR_B = new javax.swing.JList<>();
        lblMIss_mName18 = new javax.swing.JLabel();
        lblBk_R_B_bRetDt = new javax.swing.JLabel();
        lblBk_R_B_bDelay = new javax.swing.JLabel();
        pnlBk_R_C = new javax.swing.JPanel();
        btnBkD_back9 = new javax.swing.JButton();
        pnlBkI_B_chgMem4 = new javax.swing.JButton();
        btnBkShow_Go5 = new javax.swing.JButton();
        lblBkR_C_err = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lblBk_R_C_mId = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        lblBk_R_C_bId = new javax.swing.JLabel();
        lblMIss_mName19 = new javax.swing.JLabel();
        lblBk_R_C_mNm = new javax.swing.JLabel();
        lblMIss_mName20 = new javax.swing.JLabel();
        lblBk_R_C_bNm = new javax.swing.JLabel();
        lblMIss_mName21 = new javax.swing.JLabel();
        lblBk_R_C_mType = new javax.swing.JLabel();
        lblMIss_mName22 = new javax.swing.JLabel();
        lblBk_R_C_bAuth = new javax.swing.JLabel();
        lblMIss_mName23 = new javax.swing.JLabel();
        lblBk_R_C_bIssDt = new javax.swing.JLabel();
        lblMIss_mName24 = new javax.swing.JLabel();
        lblBk_R_C_bLastDt = new javax.swing.JLabel();
        lblMIss_mName25 = new javax.swing.JLabel();
        lblBk_R_C_bRetDt = new javax.swing.JLabel();
        lblBk_R_C_bDelay = new javax.swing.JLabel();
        comboBk_R_C = new javax.swing.JCheckBox();
        pnlBkR_C_sub1 = new javax.swing.JPanel();
        lblFineInfo = new javax.swing.JLabel();
        lblFineCalc = new javax.swing.JLabel();
        lblBk_R_C_1_Total = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        btnRetBkRecv = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        pnlBkR_C_sub2 = new javax.swing.JPanel();
        radioR_C_inc = new javax.swing.JRadioButton();
        radioR_C_dec = new javax.swing.JRadioButton();
        jLabel72 = new javax.swing.JLabel();
        txtBkRet_C_2_nDays = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        lblBk_R_B_bLastDt1 = new javax.swing.JLabel();
        txtBkRet_C_2_reason = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        pnlReport = new javax.swing.JPanel();
        lblRetBook1 = new javax.swing.JLabel();
        checkRep_1 = new javax.swing.JCheckBox();
        checkRep_2 = new javax.swing.JCheckBox();
        checkRep_3 = new javax.swing.JCheckBox();
        checkRep_4 = new javax.swing.JCheckBox();
        comboRep1 = new javax.swing.JComboBox<>();
        comboRep2 = new javax.swing.JComboBox<>();
        comboRep3 = new javax.swing.JComboBox<>();
        comboRep4 = new javax.swing.JComboBox<>();
        repSub1 = new javax.swing.JPanel();
        lblRepDt = new javax.swing.JLabel();
        txtRepDD = new javax.swing.JTextField();
        txtRepMM = new javax.swing.JTextField();
        txtRepYYYY = new javax.swing.JTextField();
        repSub2 = new javax.swing.JPanel();
        lblRepDt2 = new javax.swing.JLabel();
        txtRepDD2 = new javax.swing.JTextField();
        txtRepMM2 = new javax.swing.JTextField();
        txtRepYYYY2 = new javax.swing.JTextField();
        reportSubmit = new javax.swing.JButton();
        reportErr = new javax.swing.JLabel();
        reportReset = new javax.swing.JButton();
        comboRepSort1 = new javax.swing.JComboBox<>();
        comboRepSort2 = new javax.swing.JComboBox<>();
        comboRepSort3 = new javax.swing.JComboBox<>();
        comboRepSort4 = new javax.swing.JComboBox<>();
        btnReportBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 51, 0));
        setBounds(new java.awt.Rectangle(170, 10, 1000, 800));
        setResizable(false);

        pnlParentBtns.setBackground(new java.awt.Color(240, 51, 0));

        btnBkAdd.setBackground(new java.awt.Color(180, 30, 30));
        btnBkAdd.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkAdd.setForeground(new java.awt.Color(250, 250, 250));
        btnBkAdd.setText("+Books");
        btnBkAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkAddActionPerformed(evt);
            }
        });

        btnBkRemove.setBackground(new java.awt.Color(180, 30, 30));
        btnBkRemove.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkRemove.setForeground(new java.awt.Color(250, 250, 250));
        btnBkRemove.setText("- Books");
        btnBkRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkRemoveActionPerformed(evt);
            }
        });

        btnBkShow.setBackground(new java.awt.Color(180, 30, 30));
        btnBkShow.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkShow.setForeground(new java.awt.Color(250, 250, 250));
        btnBkShow.setText("Show");
        btnBkShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkShowActionPerformed(evt);
            }
        });

        btnBkIssue.setBackground(new java.awt.Color(180, 30, 30));
        btnBkIssue.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkIssue.setForeground(new java.awt.Color(250, 250, 250));
        btnBkIssue.setText("Issue");
        btnBkIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkIssueActionPerformed(evt);
            }
        });

        btnBkReturn.setBackground(new java.awt.Color(180, 30, 30));
        btnBkReturn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkReturn.setForeground(new java.awt.Color(250, 250, 250));
        btnBkReturn.setText("Return");
        btnBkReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkReturnActionPerformed(evt);
            }
        });

        btnMemRemove.setBackground(new java.awt.Color(180, 30, 30));
        btnMemRemove.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnMemRemove.setForeground(new java.awt.Color(250, 250, 250));
        btnMemRemove.setText("-Member");
        btnMemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemRemoveActionPerformed(evt);
            }
        });

        btnMemShow.setBackground(new java.awt.Color(180, 30, 30));
        btnMemShow.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnMemShow.setForeground(new java.awt.Color(250, 250, 250));
        btnMemShow.setText("About App");
        btnMemShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemShowActionPerformed(evt);
            }
        });

        btnReports.setBackground(new java.awt.Color(180, 30, 30));
        btnReports.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnReports.setForeground(new java.awt.Color(250, 250, 250));
        btnReports.setText("Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        btnBkAdvEdit.setBackground(new java.awt.Color(180, 30, 30));
        btnBkAdvEdit.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkAdvEdit.setForeground(new java.awt.Color(250, 250, 250));
        btnBkAdvEdit.setText("Edit");
        btnBkAdvEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkAdvEditActionPerformed(evt);
            }
        });

        btnBkFind.setBackground(new java.awt.Color(180, 30, 30));
        btnBkFind.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkFind.setForeground(new java.awt.Color(250, 250, 250));
        btnBkFind.setText("Adv. Edit");
        btnBkFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkFindActionPerformed(evt);
            }
        });

        btnBkAdvSer.setBackground(new java.awt.Color(180, 30, 30));
        btnBkAdvSer.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnBkAdvSer.setForeground(new java.awt.Color(250, 250, 250));
        btnBkAdvSer.setText("Adv.Search");
        btnBkAdvSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkAdvSerActionPerformed(evt);
            }
        });

        btnMemAdd.setBackground(new java.awt.Color(180, 30, 30));
        btnMemAdd.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btnMemAdd.setForeground(new java.awt.Color(250, 250, 250));
        btnMemAdd.setText("+Member");
        btnMemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlParentBtnsLayout = new javax.swing.GroupLayout(pnlParentBtns);
        pnlParentBtns.setLayout(pnlParentBtnsLayout);
        pnlParentBtnsLayout.setHorizontalGroup(
            pnlParentBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParentBtnsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlParentBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParentBtnsLayout.createSequentialGroup()
                        .addComponent(btnBkRemove)
                        .addGap(18, 18, 18)
                        .addComponent(btnBkReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBkAdvEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlParentBtnsLayout.createSequentialGroup()
                        .addComponent(btnBkAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnBkIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBkShow, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlParentBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBkAdvSer, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(btnBkFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlParentBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlParentBtnsLayout.createSequentialGroup()
                        .addComponent(btnMemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMemShow, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlParentBtnsLayout.createSequentialGroup()
                        .addComponent(btnMemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        pnlParentBtnsLayout.setVerticalGroup(
            pnlParentBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParentBtnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParentBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkShow, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkAdvSer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMemShow, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlParentBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkFind, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkAdvEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlParent.setBackground(new java.awt.Color(240, 51, 0));

        pnlLogo.setBackground(new java.awt.Color(240, 51, 0));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HomeFrame/NewOkay.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addContainerGap())
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pnlBkAdd.setBackground(new java.awt.Color(240, 241, 240));
        pnlBkAdd.setPreferredSize(new java.awt.Dimension(900, 551));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(40, 0, 240));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add Book");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Book Type       :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Book Name      :");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Rack No.          :");

        txtBkName.setBackground(new java.awt.Color(215, 255, 255));
        txtBkName.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkName.setText("Hello ");
        txtBkName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkNameActionPerformed(evt);
            }
        });

        txtBkType.setBackground(new java.awt.Color(215, 255, 255));
        txtBkType.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkType.setText("Hello ");
        txtBkType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkTypeActionPerformed(evt);
            }
        });

        txtBkRack.setBackground(new java.awt.Color(215, 255, 255));
        txtBkRack.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkRack.setText("Hello ");
        txtBkRack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkRackActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Quantity :");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Price       :");

        txtBkQty.setBackground(new java.awt.Color(215, 255, 255));
        txtBkQty.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkQty.setText("Hello ");
        txtBkQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkQtyActionPerformed(evt);
            }
        });

        txtBkPrice.setBackground(new java.awt.Color(215, 255, 255));
        txtBkPrice.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkPrice.setText("Hello ");
        txtBkPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkPriceActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("Pages     :");

        txtBkPages.setBackground(new java.awt.Color(215, 255, 255));
        txtBkPages.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkPages.setText("Hello ");
        txtBkPages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkPagesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Author  1          :");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("Author  2          :");

        txtBkAuth1.setBackground(new java.awt.Color(215, 255, 255));
        txtBkAuth1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkAuth1.setText("Hello ");
        txtBkAuth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkAuth1ActionPerformed(evt);
            }
        });

        txtBkAuth2.setBackground(new java.awt.Color(215, 255, 255));
        txtBkAuth2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkAuth2.setText("Hello ");
        txtBkAuth2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkAuth2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setText("Publisher         :");

        txtBkPub.setBackground(new java.awt.Color(215, 255, 255));
        txtBkPub.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkPub.setText("Hello ");
        txtBkPub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkPubActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setText("About Book      :");

        txtBkAbout.setBackground(new java.awt.Color(215, 255, 255));
        txtBkAbout.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkAbout.setText("Hello ");
        txtBkAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkAboutActionPerformed(evt);
            }
        });

        btnBkAddSave.setBackground(new java.awt.Color(20, 180, 20));
        btnBkAddSave.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkAddSave.setForeground(new java.awt.Color(250, 250, 250));
        btnBkAddSave.setText("Save");
        btnBkAddSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkAddSaveActionPerformed(evt);
            }
        });

        btnBkAddBack.setBackground(new java.awt.Color(20, 180, 20));
        btnBkAddBack.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkAddBack.setForeground(new java.awt.Color(250, 250, 250));
        btnBkAddBack.setText("Back");
        btnBkAddBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkAddBackActionPerformed(evt);
            }
        });

        lblBkErrSucc.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkErrSucc.setText("Book 'C++' (5) is Saved ... Successfully :)");

        javax.swing.GroupLayout pnlBkAddLayout = new javax.swing.GroupLayout(pnlBkAdd);
        pnlBkAdd.setLayout(pnlBkAddLayout);
        pnlBkAddLayout.setHorizontalGroup(
            pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkAddLayout.createSequentialGroup()
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBkAddLayout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkAddLayout.createSequentialGroup()
                        .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkAddLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlBkAddLayout.createSequentialGroup()
                                    .addGap(198, 198, 198)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBkAddLayout.createSequentialGroup()
                                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBkType, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBkName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBkRack, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBkQty, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBkPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBkPages, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtBkAuth2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBkAuth1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBkPub, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                .addComponent(txtBkAbout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
                    .addGroup(pnlBkAddLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnBkAddBack, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(btnBkAddSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkAddLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBkErrSucc, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        pnlBkAddLayout.setVerticalGroup(
            pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkAddLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkName)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBkType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkRack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkPages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkAuth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkAuth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkPub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlBkAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkAddSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkAddBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBkErrSucc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        pnlBkIssue.setPreferredSize(new java.awt.Dimension(900, 551));

        jLabel28.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(40, 0, 240));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Issue Book ");

        pnlBkI_A.setBackground(new java.awt.Color(240, 235, 240));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel51.setText("Enter Member Id   :");

        lblBkI_A_Data.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblBkI_A_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBkI_A_DataActionPerformed(evt);
            }
        });

        btnBkD_back4.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back4.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back4.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back4.setText("Back");
        btnBkD_back4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back4ActionPerformed(evt);
            }
        });

        pnlBkI_A_sub1.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_A_sub1.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_A_sub1.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_A_sub1.setText("Next");
        pnlBkI_A_sub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_A_sub1ActionPerformed(evt);
            }
        });

        lblBkI_A_err.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkI_A_err.setForeground(new java.awt.Color(250, 0, 0));

        btnBkI_A_show.setBackground(new java.awt.Color(20, 180, 20));
        btnBkI_A_show.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkI_A_show.setForeground(new java.awt.Color(250, 250, 250));
        btnBkI_A_show.setText("Show Data");
        btnBkI_A_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkI_A_showActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBkI_ALayout = new javax.swing.GroupLayout(pnlBkI_A);
        pnlBkI_A.setLayout(pnlBkI_ALayout);
        pnlBkI_ALayout.setHorizontalGroup(
            pnlBkI_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_ALayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBkI_A_err, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(pnlBkI_ALayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(pnlBkI_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkI_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlBkI_ALayout.createSequentialGroup()
                            .addComponent(btnBkD_back4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBkI_A_show, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pnlBkI_A_sub1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblBkI_A_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        pnlBkI_ALayout.setVerticalGroup(
            pnlBkI_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkI_ALayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBkI_A_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkI_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_A_sub1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkI_A_show, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBkI_A_err, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pnlBkI_B.setBackground(new java.awt.Color(240, 235, 240));

        btnBkShow_Go1.setBackground(new java.awt.Color(20, 180, 20));
        btnBkShow_Go1.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkShow_Go1.setForeground(new java.awt.Color(250, 250, 250));
        btnBkShow_Go1.setText("Next");
        btnBkShow_Go1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkShow_Go1ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel52.setText("Enter Book Id / Name / Type / Author  :");

        txtBkI_B_data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBkI_B_data.setForeground(new java.awt.Color(153, 153, 153));
        txtBkI_B_data.setText("10001");
        txtBkI_B_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkI_B_dataActionPerformed(evt);
            }
        });

        btnBkD_back3.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back3.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back3.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back3.setText("Cancel");
        btnBkD_back3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back3ActionPerformed(evt);
            }
        });

        pnlBkI_B_chgMem.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_B_chgMem.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_B_chgMem.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_B_chgMem.setText("Change Member");
        pnlBkI_B_chgMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_B_chgMemActionPerformed(evt);
            }
        });

        txtBkI_B_mem.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtBkI_B_mem.setText("Member  :");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel54.setText("Date of Book Issue");

        lblBkI_B_err.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkI_B_err.setForeground(new java.awt.Color(250, 0, 0));

        txtBkI_B_mNm.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtBkI_B_mNm.setForeground(new java.awt.Color(20, 140, 20));

        txtBkI_B_doi.setBackground(new java.awt.Color(230, 230, 230));
        txtBkI_B_doi.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        txtBkI_B_doi.setForeground(new java.awt.Color(20, 140, 20));

        txtBkI_B_mId.setBackground(new java.awt.Color(230, 230, 230));
        txtBkI_B_mId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        txtBkI_B_mId.setForeground(new java.awt.Color(20, 140, 20));

        comboBkI_B.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboBkI_B.setForeground(new java.awt.Color(210, 210, 210));
        comboBkI_B.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Condition", "Id", "Name", "Type", "Author" }));
        comboBkI_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBkI_BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBkI_BLayout = new javax.swing.GroupLayout(pnlBkI_B);
        pnlBkI_B.setLayout(pnlBkI_BLayout);
        pnlBkI_BLayout.setHorizontalGroup(
            pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkI_BLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkI_BLayout.createSequentialGroup()
                        .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_BLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBkI_B_err, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBkI_BLayout.createSequentialGroup()
                                .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlBkI_BLayout.createSequentialGroup()
                                        .addComponent(btnBkD_back3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pnlBkI_B_chgMem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBkShow_Go1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBkI_BLayout.createSequentialGroup()
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboBkI_B, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtBkI_B_data, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlBkI_BLayout.createSequentialGroup()
                                        .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtBkI_B_doi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_BLayout.createSequentialGroup()
                                                .addComponent(txtBkI_B_mem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(69, 69, 69))
                                            .addComponent(txtBkI_B_mId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(pnlBkI_BLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBkI_B_mNm, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        pnlBkI_BLayout.setVerticalGroup(
            pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkI_BLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBkI_B_mem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkI_B_mNm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBkI_B_mId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBkI_B_doi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBkI_B, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBkI_B_data, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBkI_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkShow_Go1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_B_chgMem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBkI_B_err, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        btnBkShow_Go2.setBackground(new java.awt.Color(20, 180, 20));
        btnBkShow_Go2.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkShow_Go2.setForeground(new java.awt.Color(250, 250, 250));
        btnBkShow_Go2.setText("Selected");
        btnBkShow_Go2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkShow_Go2ActionPerformed(evt);
            }
        });

        lblBk_I_C_mDoj.setEditable(false);
        lblBk_I_C_mDoj.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_C_mDoj.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblBk_I_C_mDoj.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_mDoj.setText("14-08-2019");
        lblBk_I_C_mDoj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBk_I_C_mDojActionPerformed(evt);
            }
        });

        lblBk_I_C_mId.setEditable(false);
        lblBk_I_C_mId.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_C_mId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblBk_I_C_mId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_mId.setText("1034");
        lblBk_I_C_mId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBk_I_C_mIdActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel55.setText("Date of Issue");

        lblBkI_C.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblBkI_C.setText("        Member   :");

        btnBkD_back5.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back5.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back5.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back5.setText("Cancel");
        btnBkD_back5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back5ActionPerformed(evt);
            }
        });

        pnlBkI_B_chgMem1.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_B_chgMem1.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_B_chgMem1.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_B_chgMem1.setText("Re-Search");
        pnlBkI_B_chgMem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_B_chgMem1ActionPerformed(evt);
            }
        });

        jScrollPane3.setPreferredSize(new java.awt.Dimension(800, 600));

        listBkShow1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listBkShow1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listBkShow1.setPreferredSize(new java.awt.Dimension(1000, 800));
        listBkShow1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBkShow1ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listBkShow1);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel62.setText(" Book Id           :");

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel63.setText(" Book Name    :");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel64.setText(" Author             :");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel65.setText(" Type                :");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel66.setText(" Availables      :");

        lblBk_I_C_bId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_C_bId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_bId.setText("10001");

        lblBk_I_C_bName.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_C_bName.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_bName.setText("A");

        lblBk_I_C_bAuth.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_C_bAuth.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_bAuth.setText("B");

        lblBk_I_C_bType.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_C_bType.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_bType.setText("C");

        lblBk_I_C_bAvb.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_C_bAvb.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_bAvb.setText("D");

        lblBk_I_C_mName.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_C_mName.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_C_mName.setText("Shubham");

        javax.swing.GroupLayout pnlBkI_CLayout = new javax.swing.GroupLayout(pnlBkI_C);
        pnlBkI_C.setLayout(pnlBkI_CLayout);
        pnlBkI_CLayout.setHorizontalGroup(
            pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkI_CLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkI_CLayout.createSequentialGroup()
                        .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_I_C_mDoj, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_CLayout.createSequentialGroup()
                                .addComponent(lblBkI_C, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBk_I_C_mName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_CLayout.createSequentialGroup()
                                .addComponent(lblBk_I_C_mId, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_CLayout.createSequentialGroup()
                        .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_CLayout.createSequentialGroup()
                                .addComponent(btnBkD_back5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addComponent(pnlBkI_B_chgMem1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(btnBkShow_Go2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(133, 133, 133))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_CLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBk_I_C_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblBk_I_C_bAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBk_I_C_bName, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBk_I_C_bType, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_C_bAvb, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(146, 146, 146))
        );
        pnlBkI_CLayout.setVerticalGroup(
            pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkI_CLayout.createSequentialGroup()
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBkI_C, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_C_mName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBk_I_C_mId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_C_mDoj, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(lblBk_I_C_bId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(lblBk_I_C_bName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(lblBk_I_C_bAuth))
                .addGap(12, 12, 12)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(lblBk_I_C_bType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(lblBk_I_C_bAvb, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlBkI_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkShow_Go2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_B_chgMem1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlBkI_D.setBackground(new java.awt.Color(240, 235, 240));

        btnBkShow_Go3.setBackground(new java.awt.Color(20, 180, 20));
        btnBkShow_Go3.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkShow_Go3.setForeground(new java.awt.Color(250, 250, 250));
        btnBkShow_Go3.setText("Finally - Issue");
        btnBkShow_Go3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkShow_Go3ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel56.setText("Member Id : ");

        lblMIss_mName2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName2.setText("Member      :");

        lblMIss_mName3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName3.setText("Author        :");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel57.setText("Book Id : ");

        lblMIss_mName4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName4.setText("Book      :");

        lblMIss_mName5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName5.setText(" to ");

        btnBkD_back6.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back6.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back6.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back6.setText("Cancel");
        btnBkD_back6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back6ActionPerformed(evt);
            }
        });

        pnlBkI_B_chgMem2.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_B_chgMem2.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_B_chgMem2.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_B_chgMem2.setText("Back");
        pnlBkI_B_chgMem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_B_chgMem2ActionPerformed(evt);
            }
        });

        lblMIss_mName6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName6.setText("Issuing Date  :");

        lblMIss_mName7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName7.setText("Last Date to Return  :");

        lblMIss_mName8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName8.setText("Issuing a Book of -");

        lblBk_I_D_bIssDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_D_bIssDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_bIssDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_I_D_bIssDt.setText("Jul 23,2019");

        lblBk_I_D_bRetDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_D_bRetDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_bRetDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_I_D_bRetDt.setText("Aug 24,2019");

        lblBk_I_D_bNm2.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_D_bNm2.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_bNm2.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_bNm2.setText("Java");

        lblMIss_mName9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName9.setText("Type      :");

        lblBk_I_D_mNm2.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_D_mNm2.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_mNm2.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_mNm2.setText("Shubham");

        lblBk_I_D_mId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_mId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_mId.setText("1001");

        lblBk_I_D_mNm.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_mNm.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_mNm.setText("Shubham sri");

        lblBk_I_D_mAuth.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_mAuth.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_mAuth.setText("Martin Luthor king");

        lblBk_I_D_bId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_bId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_bId.setText("10002");

        lblBk_I_D_bNm.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_bNm.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_bNm.setText("Visual Basic");

        lblBk_I_D_bType.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_bType.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_bType.setText("Student");

        lblBkI_D_err.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkI_D_err.setForeground(new java.awt.Color(250, 0, 0));
        lblBkI_D_err.setText("Error msg");

        javax.swing.GroupLayout pnlBkI_DLayout = new javax.swing.GroupLayout(pnlBkI_D);
        pnlBkI_D.setLayout(pnlBkI_DLayout);
        pnlBkI_DLayout.setHorizontalGroup(
            pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_DLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_DLayout.createSequentialGroup()
                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMIss_mName7)
                            .addComponent(lblMIss_mName6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBk_I_D_bIssDt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_I_D_bRetDt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_DLayout.createSequentialGroup()
                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblBkI_D_err, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                        .addComponent(btnBkD_back6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))
                                    .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                        .addComponent(lblMIss_mName8)
                                        .addGap(11, 11, 11)))
                                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                        .addComponent(pnlBkI_B_chgMem2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBkI_DLayout.createSequentialGroup()
                                        .addComponent(lblBk_I_D_bNm2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblMIss_mName5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))
                                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblBk_I_D_mNm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBkShow_Go3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(lblBk_I_D_mId, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblMIss_mName4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMIss_mName9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(lblBk_I_D_bType, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_DLayout.createSequentialGroup()
                                                .addComponent(lblBk_I_D_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_DLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBk_I_D_bNm, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(98, 98, 98))))
            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMIss_mName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMIss_mName3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBk_I_D_mAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_D_mNm, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlBkI_DLayout.setVerticalGroup(
            pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBkI_DLayout.createSequentialGroup()
                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                        .addComponent(lblBk_I_D_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblBk_I_D_bNm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblBk_I_D_mId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblMIss_mName2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblBk_I_D_mNm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblMIss_mName3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblBk_I_D_mAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblBk_I_D_bType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblMIss_mName4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                            .addGap(64, 64, 64)
                                            .addComponent(lblMIss_mName9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBk_I_D_bIssDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBkI_DLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(lblMIss_mName6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMIss_mName7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBk_I_D_bRetDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMIss_mName8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_D_bNm2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMIss_mName5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_D_mNm2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBkI_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkShow_Go3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_B_chgMem2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBkI_D_err, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBkIssueLayout = new javax.swing.GroupLayout(pnlBkIssue);
        pnlBkIssue.setLayout(pnlBkIssueLayout);
        pnlBkIssueLayout.setHorizontalGroup(
            pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkIssueLayout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkIssueLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(pnlBkI_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkIssueLayout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(pnlBkI_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
            .addGroup(pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkIssueLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkI_C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkIssueLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkI_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlBkIssueLayout.setVerticalGroup(
            pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkIssueLayout.createSequentialGroup()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlBkI_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkIssueLayout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(pnlBkI_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(130, Short.MAX_VALUE)))
            .addGroup(pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkIssueLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkI_C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlBkIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkIssueLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkI_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlBkShow.setBackground(new java.awt.Color(240, 241, 240));
        pnlBkShow.setPreferredSize(new java.awt.Dimension(900, 551));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(40, 0, 240));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("All Books");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        listBkShow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listBkShow.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listBkShow.setPreferredSize(new java.awt.Dimension(1000, 800));
        jScrollPane1.setViewportView(listBkShow);

        lblBkShowErr.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowErr.setText("OOPs ... Something Went Wrong.");

        lblBkShowTotalBk.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowTotalBk.setText("Total Books :");

        lblBkShowNBks.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowNBks.setText("0");

        lblBkShowBkQty.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowBkQty.setText("Total Qty :");

        lblBkShowNBkQty.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowNBkQty.setText("0");

        lblBkShowBkStsA.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowBkStsA.setText("Available :");

        lblBkShowNBkStsA.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowNBkStsA.setText("0");

        lblBkShowBkStsI.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowBkStsI.setText("Issued :");

        lblBkShowNBkStsI.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowNBkStsI.setText("0");

        lblBkShowBkStsR.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowBkStsR.setText("Repair :");

        lblBkShowNBkStsR.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkShowNBkStsR.setText("0");

        javax.swing.GroupLayout pnlBkShowLayout = new javax.swing.GroupLayout(pnlBkShow);
        pnlBkShow.setLayout(pnlBkShowLayout);
        pnlBkShowLayout.setHorizontalGroup(
            pnlBkShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkShowLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBkShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkShowLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkShowLayout.createSequentialGroup()
                        .addComponent(lblBkShowErr)
                        .addGap(333, 333, 333))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkShowLayout.createSequentialGroup()
                .addGap(0, 102, Short.MAX_VALUE)
                .addGroup(pnlBkShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBkShowLayout.createSequentialGroup()
                        .addComponent(lblBkShowTotalBk, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lblBkShowNBks, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBkShowBkQty, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBkShowNBkQty, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBkShowBkStsA, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBkShowNBkStsA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(lblBkShowBkStsI, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBkShowNBkStsI, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBkShowBkStsR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBkShowNBkStsR, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116))
        );
        pnlBkShowLayout.setVerticalGroup(
            pnlBkShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBkShowErr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBkShowTotalBk)
                    .addComponent(lblBkShowNBks)
                    .addComponent(lblBkShowBkQty)
                    .addComponent(lblBkShowNBkQty)
                    .addComponent(lblBkShowBkStsA)
                    .addComponent(lblBkShowNBkStsA)
                    .addComponent(lblBkShowBkStsI)
                    .addComponent(lblBkShowNBkStsI)
                    .addComponent(lblBkShowBkStsR)
                    .addComponent(lblBkShowNBkStsR))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnlBkEdit.setBackground(new java.awt.Color(240, 51, 0));
        pnlBkEdit.setPreferredSize(new java.awt.Dimension(900, 551));

        pnlBkE_Input.setBackground(new java.awt.Color(240, 241, 240));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("Enter Book Id / Name");

        txtBkEdit_find.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtBkEdit_find.setText("10001");
        txtBkEdit_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkEdit_findActionPerformed(evt);
            }
        });

        btnBkShow_Go.setBackground(new java.awt.Color(20, 180, 20));
        btnBkShow_Go.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkShow_Go.setForeground(new java.awt.Color(250, 250, 250));
        btnBkShow_Go.setText("Go");
        btnBkShow_Go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkShow_GoActionPerformed(evt);
            }
        });

        btnBkD_back2.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back2.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back2.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back2.setText("Back");
        btnBkD_back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBkE_InputLayout = new javax.swing.GroupLayout(pnlBkE_Input);
        pnlBkE_Input.setLayout(pnlBkE_InputLayout);
        pnlBkE_InputLayout.setHorizontalGroup(
            pnlBkE_InputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkE_InputLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkE_InputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBkE_InputLayout.createSequentialGroup()
                        .addComponent(btnBkD_back2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBkShow_Go, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBkEdit_find, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlBkE_InputLayout.setVerticalGroup(
            pnlBkE_InputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkE_InputLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(pnlBkE_InputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBkEdit_find, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkE_InputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkShow_Go, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(40, 0, 240));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Enter Book Details");

        lblBkEditErr.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkEditErr.setForeground(new java.awt.Color(250, 250, 250));
        lblBkEditErr.setText("Book 'C++' (5) is Saved ... Successfully :)");

        javax.swing.GroupLayout pnlBkEditLayout = new javax.swing.GroupLayout(pnlBkEdit);
        pnlBkEdit.setLayout(pnlBkEditLayout);
        pnlBkEditLayout.setHorizontalGroup(
            pnlBkEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkEditLayout.createSequentialGroup()
                .addGroup(pnlBkEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkEditLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkEditLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(pnlBkE_Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkEditLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblBkEditErr, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        pnlBkEditLayout.setVerticalGroup(
            pnlBkEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkEditLayout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(pnlBkE_Input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(lblBkEditErr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pnlBkEditNow.setPreferredSize(new java.awt.Dimension(900, 551));

        jLabel16.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(40, 0, 240));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Edit Book ");

        lblBkEditNowErr.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkEditNowErr.setForeground(new java.awt.Color(250, 0, 0));
        lblBkEditNowErr.setText("Here Message will show...");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setText("Book Name");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setText("Book Type");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setText("Rack No.");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setText("Author 1");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setText("Author 2");

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setText("Publisher");

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel23.setText("About Book");

        txtBkE_name.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_name.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_name.setText("Hello ");
        txtBkE_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_nameActionPerformed(evt);
            }
        });

        txtBkE_type.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_type.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_type.setText("Hello ");
        txtBkE_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_typeActionPerformed(evt);
            }
        });

        txtBkE_rack.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_rack.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_rack.setText("Hello ");
        txtBkE_rack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_rackActionPerformed(evt);
            }
        });

        txtBkE_auth1.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_auth1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_auth1.setText("Hello ");
        txtBkE_auth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_auth1ActionPerformed(evt);
            }
        });

        txtBkE_auth2.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_auth2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_auth2.setText("Hello ");
        txtBkE_auth2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_auth2ActionPerformed(evt);
            }
        });

        txtBkE_pub.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_pub.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_pub.setText("Hello ");
        txtBkE_pub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_pubActionPerformed(evt);
            }
        });

        txtBkE_about.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_about.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_about.setText("Hello ");
        txtBkE_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_aboutActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setText("Quantity");

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel25.setText("Price");

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel26.setText("Pages");

        txtBkE_qty.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_qty.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_qty.setText("Hello ");
        txtBkE_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_qtyActionPerformed(evt);
            }
        });

        txtBkE_price.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_price.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_price.setText("Hello ");
        txtBkE_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_priceActionPerformed(evt);
            }
        });

        txtBkE_pages.setBackground(new java.awt.Color(215, 255, 255));
        txtBkE_pages.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtBkE_pages.setText("Hello ");
        txtBkE_pages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkE_pagesActionPerformed(evt);
            }
        });

        btnBkE_back.setBackground(new java.awt.Color(20, 180, 20));
        btnBkE_back.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkE_back.setForeground(new java.awt.Color(250, 250, 250));
        btnBkE_back.setText("Back");
        btnBkE_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkE_backActionPerformed(evt);
            }
        });

        btnBkE_update.setBackground(new java.awt.Color(20, 180, 20));
        btnBkE_update.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkE_update.setForeground(new java.awt.Color(250, 250, 250));
        btnBkE_update.setText("Update Now");
        btnBkE_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkE_updateActionPerformed(evt);
            }
        });

        btnBkE_showBks.setBackground(new java.awt.Color(20, 180, 20));
        btnBkE_showBks.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkE_showBks.setForeground(new java.awt.Color(250, 250, 250));
        btnBkE_showBks.setText("Show Books");
        btnBkE_showBks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkE_showBksActionPerformed(evt);
            }
        });

        lblBkE_id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBkE_id.setText("Id : 12345");

        javax.swing.GroupLayout pnlBkEditNowLayout = new javax.swing.GroupLayout(pnlBkEditNow);
        pnlBkEditNow.setLayout(pnlBkEditNowLayout);
        pnlBkEditNowLayout.setHorizontalGroup(
            pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkEditNowLayout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkEditNowLayout.createSequentialGroup()
                        .addComponent(btnBkE_back, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBkEditNowLayout.createSequentialGroup()
                                .addComponent(btnBkE_showBks, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBkE_update, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBkEditNowLayout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254)
                                .addComponent(lblBkE_id, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkEditNowLayout.createSequentialGroup()
                        .addComponent(lblBkEditNowErr, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
            .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkEditNowLayout.createSequentialGroup()
                    .addGap(189, 189, 189)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBkEditNowLayout.createSequentialGroup()
                            .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBkE_type, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBkE_name, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBkE_rack, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)
                            .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBkE_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBkE_price, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBkE_pages, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBkE_auth2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBkE_auth1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBkE_pub, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(txtBkE_about, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
                    .addContainerGap(190, Short.MAX_VALUE)))
        );
        pnlBkEditNowLayout.setVerticalGroup(
            pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkEditNowLayout.createSequentialGroup()
                .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBkE_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkE_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkE_showBks, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkE_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblBkEditNowErr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkEditNowLayout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_name)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBkE_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBkE_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_rack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_pages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_auth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_auth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_pub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlBkEditNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBkE_about, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(167, 167, 167)))
        );

        pnlBkDel.setBackground(new java.awt.Color(240, 51, 0));

        jLabel27.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(40, 0, 240));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Enter Book Detail");

        pnlBkE_Input1.setBackground(new java.awt.Color(240, 241, 240));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel29.setText("Enter Book Id / Name");

        txtBkD_data.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtBkD_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBkD_dataActionPerformed(evt);
            }
        });

        btnBkD_del.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_del.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_del.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_del.setText("Delete");
        btnBkD_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_delActionPerformed(evt);
            }
        });

        btnBkD_back.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back.setText("Back");
        btnBkD_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBkE_Input1Layout = new javax.swing.GroupLayout(pnlBkE_Input1);
        pnlBkE_Input1.setLayout(pnlBkE_Input1Layout);
        pnlBkE_Input1Layout.setHorizontalGroup(
            pnlBkE_Input1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkE_Input1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkE_Input1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlBkE_Input1Layout.createSequentialGroup()
                        .addComponent(btnBkD_back, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBkD_del, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBkD_data, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pnlBkE_Input1Layout.setVerticalGroup(
            pnlBkE_Input1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkE_Input1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(pnlBkE_Input1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBkD_data, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBkE_Input1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkD_del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        lblBkD_errMsg.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkD_errMsg.setForeground(new java.awt.Color(250, 250, 250));
        lblBkD_errMsg.setText("Book 'C++' (5) is Saved ... Successfully :)");

        javax.swing.GroupLayout pnlBkDelLayout = new javax.swing.GroupLayout(pnlBkDel);
        pnlBkDel.setLayout(pnlBkDelLayout);
        pnlBkDelLayout.setHorizontalGroup(
            pnlBkDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDelLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(pnlBkDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDelLayout.createSequentialGroup()
                        .addComponent(pnlBkE_Input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDelLayout.createSequentialGroup()
                        .addComponent(lblBkD_errMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        pnlBkDelLayout.setVerticalGroup(
            pnlBkDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(pnlBkE_Input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBkD_errMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        jScrollPane4.setPreferredSize(new java.awt.Dimension(800, 600));

        listBkDel_B.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listBkDel_B.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listBkDel_B.setPreferredSize(new java.awt.Dimension(1000, 800));
        listBkDel_B.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBkDel_BValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listBkDel_B);

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel76.setText(" Book Id           :");

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel77.setText(" Book Name    :");

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel78.setText(" Author             :");

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel79.setText(" Issued             :");

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel80.setText(" Available        :");

        lblBk_D_B_bId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_D_B_bId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_D_B_bId.setText("10001");

        lblBk_D_B_bName.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_D_B_bName.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_D_B_bName.setText("A");

        lblBk_D_B_bAuth.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_D_B_bAuth.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_D_B_bAuth.setText("B");

        lblBk_D_B_bType.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_D_B_bType.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_D_B_bType.setText("C");

        lblBk_D_B_bAvb.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_D_B_bAvb.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_D_B_bAvb.setText("D");

        btnBkD_back10.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back10.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back10.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back10.setText("Cancel");
        btnBkD_back10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back10ActionPerformed(evt);
            }
        });

        pnlBkI_B_chgMem5.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_B_chgMem5.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_B_chgMem5.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_B_chgMem5.setText("Re-Search");
        pnlBkI_B_chgMem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_B_chgMem5ActionPerformed(evt);
            }
        });

        btnBkShow_Go4.setBackground(new java.awt.Color(20, 180, 20));
        btnBkShow_Go4.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkShow_Go4.setForeground(new java.awt.Color(250, 250, 250));
        btnBkShow_Go4.setText("Selected");
        btnBkShow_Go4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkShow_Go4ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(40, 0, 240));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Delete Book");

        javax.swing.GroupLayout pnlBkDel_BLayout = new javax.swing.GroupLayout(pnlBkDel_B);
        pnlBkDel_B.setLayout(pnlBkDel_BLayout);
        pnlBkDel_BLayout.setHorizontalGroup(
            pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDel_BLayout.createSequentialGroup()
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkDel_BLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkDel_BLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnBkD_back10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(pnlBkI_B_chgMem5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(btnBkShow_Go4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDel_BLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBk_D_B_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblBk_D_B_bAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBk_D_B_bName, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBk_D_B_bType, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_D_B_bAvb, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
            .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkDel_BLayout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(114, 114, 114)))
        );
        pnlBkDel_BLayout.setVerticalGroup(
            pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDel_BLayout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(lblBk_D_B_bId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(lblBk_D_B_bName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(lblBk_D_B_bAuth))
                .addGap(12, 12, 12)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(lblBk_D_B_bType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(lblBk_D_B_bAvb, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkShow_Go4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_B_chgMem5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
            .addGroup(pnlBkDel_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkDel_BLayout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(281, Short.MAX_VALUE)))
        );

        pnlBkDelNow.setBackground(new java.awt.Color(240, 241, 240));
        pnlBkDelNow.setPreferredSize(new java.awt.Dimension(900, 550));

        jLabel30.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(40, 0, 240));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Delete Book");

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel31.setText("Book Name  :");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Book Type    :");

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel32.setText("Quantity       :");

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel33.setText("Author 1       :");

        btnBkDel_E_back.setBackground(new java.awt.Color(20, 180, 20));
        btnBkDel_E_back.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkDel_E_back.setForeground(new java.awt.Color(250, 250, 250));
        btnBkDel_E_back.setText("Back");
        btnBkDel_E_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkDel_E_backActionPerformed(evt);
            }
        });

        btnBkDel_E.setBackground(new java.awt.Color(20, 180, 20));
        btnBkDel_E.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkDel_E.setForeground(new java.awt.Color(250, 250, 250));
        btnBkDel_E.setText("Delete");
        btnBkDel_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkDel_EActionPerformed(evt);
            }
        });

        lblBkDel_E_Err.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblBkDel_E_Err.setForeground(new java.awt.Color(255, 51, 0));
        lblBkDel_E_Err.setText("ErrMsg : Book 'C++' (5) not Deleted !");

        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel36.setText("Repaired");

        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel34.setText("Available");

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel37.setText("Destroyed");

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel35.setText("Issued");

        lblBkDelE_Btype.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_Btype.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_Btype.setText("Book ka type");

        lblBkDelE_Bname.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_Bname.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_Bname.setText("Book ka naam");

        lblBkDelE_auth.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_auth.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_auth.setText("Book Author");

        lblBkDelE_qty.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_qty.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_qty.setText("Qty");

        lblBkDelE_nIss.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_nIss.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_nIss.setText("001");

        lblBkDelE_nAva.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_nAva.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_nAva.setText("002");

        lblBkDelE_nRep.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_nRep.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_nRep.setText("003");

        lblBkDelE_nDes.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblBkDelE_nDes.setForeground(new java.awt.Color(20, 180, 20));
        lblBkDelE_nDes.setText("004");

        jLabel38.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel38.setText("Reason Behind Deletion  :");

        lblBkDelE_rbtnMem.setFont(new java.awt.Font("Segoe WP Semibold", 3, 13)); // NOI18N
        lblBkDelE_rbtnMem.setText("Member Lost The Book");
        lblBkDelE_rbtnMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBkDelE_rbtnMemActionPerformed(evt);
            }
        });

        lblBkDelE_rbtnOth.setFont(new java.awt.Font("Segoe WP Semibold", 3, 13)); // NOI18N
        lblBkDelE_rbtnOth.setText("Other Reasons");
        lblBkDelE_rbtnOth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBkDelE_rbtnOthActionPerformed(evt);
            }
        });

        lblBkDel_E_mid.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkDel_E_mid.setText("         Enter Member Id     :");

        txtBkDel_E_mid.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N

        javax.swing.GroupLayout pnlBkDelE_mLayout = new javax.swing.GroupLayout(pnlBkDelE_m);
        pnlBkDelE_m.setLayout(pnlBkDelE_mLayout);
        pnlBkDelE_mLayout.setHorizontalGroup(
            pnlBkDelE_mLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelE_mLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblBkDel_E_mid, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBkDel_E_mid, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBkDelE_mLayout.setVerticalGroup(
            pnlBkDelE_mLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelE_mLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlBkDelE_mLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBkDel_E_mid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBkDel_E_mid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lblBkDel_E_mid1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkDel_E_mid1.setText(" Feed Proper Reason      :");

        txtAreaBkDel_E.setColumns(20);
        txtAreaBkDel_E.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        txtAreaBkDel_E.setRows(5);
        jScrollPane2.setViewportView(txtAreaBkDel_E);

        javax.swing.GroupLayout pnlBkDelE_oLayout = new javax.swing.GroupLayout(pnlBkDelE_o);
        pnlBkDelE_o.setLayout(pnlBkDelE_oLayout);
        pnlBkDelE_oLayout.setHorizontalGroup(
            pnlBkDelE_oLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelE_oLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblBkDel_E_mid1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2))
        );
        pnlBkDelE_oLayout.setVerticalGroup(
            pnlBkDelE_oLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelE_oLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblBkDel_E_mid1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBkDelE_oLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblBkDelE_Bid.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblBkDelE_Bid.setText("Book Id : 10001");

        javax.swing.GroupLayout pnlBkDelNowLayout = new javax.swing.GroupLayout(pnlBkDelNow);
        pnlBkDelNow.setLayout(pnlBkDelNowLayout);
        pnlBkDelNowLayout.setHorizontalGroup(
            pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblBkDelE_nIss, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                            .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(2, 2, 2))
                        .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblBkDelE_nRep, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(lblBkDelE_nDes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBkDelE_Btype, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBkDelE_Bname, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBkDelE_auth, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBkDelE_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBkDel_E_Err, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDelNowLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblBkDelE_rbtnMem)
                                .addGap(18, 18, 18)
                                .addComponent(lblBkDelE_rbtnOth))
                            .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                                .addGap(366, 366, 366)
                                .addComponent(lblBkDelE_nAva, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(179, 179, 179)))
                        .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                            .addGap(209, 209, 209)
                            .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                                    .addGap(137, 137, 137)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46))
                                .addComponent(pnlBkDelE_m, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlBkDelE_o, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDelNowLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(btnBkDel_E_back, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lblBkDelE_Bid, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBkDelNowLayout.setVerticalGroup(
            pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBkDelNowLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBkDelE_Bid)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBkDelE_Bname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBkDelE_Btype, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBkDelE_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBkDelE_auth, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBkDelE_nIss, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBkDelE_nAva, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBkDelE_nDes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBkDelE_nRep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBkDelE_rbtnOth, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBkDelE_rbtnMem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBkDelE_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBkDelE_o, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkDelNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkDel_E_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBkDel_E_Err, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlBkDel_D.setBackground(new java.awt.Color(240, 51, 0));

        pnlBkE_Input2.setBackground(new java.awt.Color(240, 241, 240));

        jScrollPane5.setPreferredSize(new java.awt.Dimension(800, 600));

        listBkDel_D.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listBkDel_D.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listBkDel_D.setPreferredSize(new java.awt.Dimension(1000, 800));
        listBkDel_D.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBkDel_DValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(listBkDel_D);

        btnBkDel_D_Submit.setBackground(new java.awt.Color(20, 180, 20));
        btnBkDel_D_Submit.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkDel_D_Submit.setForeground(new java.awt.Color(250, 250, 250));
        btnBkDel_D_Submit.setText("Continue...");
        btnBkDel_D_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkDel_D_SubmitActionPerformed(evt);
            }
        });

        btnBkDel_D_Cancel.setBackground(new java.awt.Color(20, 180, 20));
        btnBkDel_D_Cancel.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkDel_D_Cancel.setForeground(new java.awt.Color(250, 250, 250));
        btnBkDel_D_Cancel.setText("Cancel");
        btnBkDel_D_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkDel_D_CancelActionPerformed(evt);
            }
        });

        btnBkDel_D_Back.setBackground(new java.awt.Color(20, 180, 20));
        btnBkDel_D_Back.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkDel_D_Back.setForeground(new java.awt.Color(250, 250, 250));
        btnBkDel_D_Back.setText("Back");
        btnBkDel_D_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkDel_D_BackActionPerformed(evt);
            }
        });

        lblMetaInfoInBkDel_D.setBackground(new java.awt.Color(200, 200, 200));
        lblMetaInfoInBkDel_D.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblMetaInfoInBkDel_D.setText("Here Meta data of Books issued to this member will show...");

        javax.swing.GroupLayout pnlBkE_Input2Layout = new javax.swing.GroupLayout(pnlBkE_Input2);
        pnlBkE_Input2.setLayout(pnlBkE_Input2Layout);
        pnlBkE_Input2Layout.setHorizontalGroup(
            pnlBkE_Input2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkE_Input2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlBkE_Input2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBkE_Input2Layout.createSequentialGroup()
                        .addComponent(btnBkDel_D_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                        .addComponent(btnBkDel_D_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(btnBkDel_D_Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkE_Input2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlBkE_Input2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMetaInfoInBkDel_D, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37))
        );
        pnlBkE_Input2Layout.setVerticalGroup(
            pnlBkE_Input2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkE_Input2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblMetaInfoInBkDel_D, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBkE_Input2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkDel_D_Submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBkDel_D_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBkDel_D_Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        jLabel84.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(40, 0, 240));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("Delete Book");

        javax.swing.GroupLayout pnlBkDel_DLayout = new javax.swing.GroupLayout(pnlBkDel_D);
        pnlBkDel_D.setLayout(pnlBkDel_DLayout);
        pnlBkDel_DLayout.setHorizontalGroup(
            pnlBkDel_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDel_DLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(pnlBkE_Input2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDel_DLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
        );
        pnlBkDel_DLayout.setVerticalGroup(
            pnlBkDel_DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDel_DLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel84)
                .addGap(84, 84, 84)
                .addComponent(pnlBkE_Input2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel81.setText("Member Id : ");

        lblBk_R_B_mId1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_mId1.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_R_B_mId1.setText("1001");

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel82.setText("Book Id :");

        lblBk_R_B_bId1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bId1.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_R_B_bId1.setText("10002");

        lblMIss_mName26.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName26.setText("Member      :");

        lblBk_R_B_mNm1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_mNm1.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_R_B_mNm1.setText("Shubham sri");

        lblMIss_mName27.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName27.setText("Book      :");

        lblBk_R_B_bNm1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bNm1.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_R_B_bNm1.setText("Visual Basic");

        lblMIss_mName28.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName28.setText("Type            :");

        lblBk_R_B_mType1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_mType1.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_R_B_mType1.setText("Student");

        lblMIss_mName29.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName29.setText("Author   :");

        lblBk_R_B_bAuth1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bAuth1.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_R_B_bAuth1.setText("Martin Luthor");

        lblMIss_mName30.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName30.setText("Today          :");

        lblBk_R_B_bIssDt1.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bIssDt1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bIssDt1.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_B_bIssDt1.setText("Wed Jul 23,2019");

        lblMIss_mName31.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName31.setText(" Issued   :");

        lblBk_R_B_bLastDt2.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bLastDt2.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bLastDt2.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_B_bLastDt2.setText("Sat Aug 24,2019");

        lblMIss_mName32.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName32.setText("  Deleting a Book of");

        lblBk_R_B_bNm3.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bNm3.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bNm3.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_R_B_bNm3.setText("Java");

        lblMIss_mName33.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName33.setText("Lost by");

        lblBk_I_D_mNm4.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_D_mNm4.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_mNm4.setForeground(new java.awt.Color(20, 180, 20));
        lblBk_I_D_mNm4.setText("Shubham");

        btnBack_pnlBkDel_E.setBackground(new java.awt.Color(20, 180, 20));
        btnBack_pnlBkDel_E.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBack_pnlBkDel_E.setForeground(new java.awt.Color(250, 250, 250));
        btnBack_pnlBkDel_E.setText("Back");
        btnBack_pnlBkDel_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack_pnlBkDel_EActionPerformed(evt);
            }
        });

        btnCancel_pnlBkDel_E.setBackground(new java.awt.Color(20, 180, 20));
        btnCancel_pnlBkDel_E.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnCancel_pnlBkDel_E.setForeground(new java.awt.Color(250, 250, 250));
        btnCancel_pnlBkDel_E.setText("Cancel");
        btnCancel_pnlBkDel_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel_pnlBkDel_EActionPerformed(evt);
            }
        });

        btnSubmit_pnlBkDel_E.setBackground(new java.awt.Color(20, 180, 20));
        btnSubmit_pnlBkDel_E.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnSubmit_pnlBkDel_E.setForeground(new java.awt.Color(250, 250, 250));
        btnSubmit_pnlBkDel_E.setText("Delete Now");
        btnSubmit_pnlBkDel_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit_pnlBkDel_EActionPerformed(evt);
            }
        });

        lblBkR_B_err1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkR_B_err1.setForeground(new java.awt.Color(250, 0, 0));
        lblBkR_B_err1.setText("  ..");

        jLabel83.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(40, 0, 240));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("Delete Book");

        pnlBkR_C_sub3.setBackground(new java.awt.Color(245, 245, 245));

        lblFineInfo1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblFineInfo1.setText("Fine for Book Lost :");

        lblFineCalc1.setBackground(new java.awt.Color(230, 230, 230));
        lblFineCalc1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblFineCalc1.setForeground(new java.awt.Color(255, 0, 0));
        lblFineCalc1.setText("399.0 Rupees");

        btnRetBkRecv1.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnRetBkRecv1.setForeground(new java.awt.Color(255, 0, 0));
        btnRetBkRecv1.setText("Receive");
        btnRetBkRecv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetBkRecv1ActionPerformed(evt);
            }
        });

        jLabel85.setBackground(new java.awt.Color(210, 210, 210));
        jLabel85.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(50, 100, 100));
        jLabel85.setText("Fine Details : ");

        javax.swing.GroupLayout pnlBkR_C_sub3Layout = new javax.swing.GroupLayout(pnlBkR_C_sub3);
        pnlBkR_C_sub3.setLayout(pnlBkR_C_sub3Layout);
        pnlBkR_C_sub3Layout.setHorizontalGroup(
            pnlBkR_C_sub3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkR_C_sub3Layout.createSequentialGroup()
                .addGroup(pnlBkR_C_sub3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkR_C_sub3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFineInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFineCalc1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkR_C_sub3Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(btnRetBkRecv1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        pnlBkR_C_sub3Layout.setVerticalGroup(
            pnlBkR_C_sub3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkR_C_sub3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkR_C_sub3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(pnlBkR_C_sub3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFineInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFineCalc1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRetBkRecv1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout pnlBkDel_ELayout = new javax.swing.GroupLayout(pnlBkDel_E);
        pnlBkDel_E.setLayout(pnlBkDel_ELayout);
        pnlBkDel_ELayout.setHorizontalGroup(
            pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDel_ELayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                            .addComponent(btnBack_pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(67, 67, 67)
                            .addComponent(btnCancel_pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSubmit_pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(lblBkR_B_err1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                            .addComponent(lblMIss_mName32)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblBk_R_B_bNm3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMIss_mName33, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblBk_I_D_mNm4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(pnlBkR_C_sub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(170, 170, 170))
            .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                                .addComponent(lblMIss_mName30, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBk_R_B_bIssDt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDel_ELayout.createSequentialGroup()
                                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMIss_mName26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMIss_mName28, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblBk_R_B_mNm1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBk_R_B_mId1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBk_R_B_mType1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblMIss_mName27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkDel_ELayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(lblMIss_mName29)))
                            .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMIss_mName31, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblBk_R_B_bId1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBk_R_B_bNm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBk_R_B_bAuth1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBk_R_B_bLastDt2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBkDel_ELayout.setVerticalGroup(
            pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_B_mId1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMIss_mName26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_B_mNm1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMIss_mName28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_B_mType1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMIss_mName30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_B_bIssDt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                                .addComponent(lblBk_R_B_bId1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBk_R_B_bNm1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMIss_mName27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBkDel_ELayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMIss_mName29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBk_R_B_bAuth1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(7, 7, 7)
                        .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMIss_mName31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_B_bLastDt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMIss_mName33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_D_mNm4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMIss_mName32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_R_B_bNm3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlBkR_C_sub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlBkDel_ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack_pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel_pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmit_pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBkR_B_err1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlMAdd.setBackground(new java.awt.Color(220, 220, 220));
        pnlMAdd.setPreferredSize(new java.awt.Dimension(900, 550));

        btnMAdd_submit.setBackground(new java.awt.Color(20, 140, 20));
        btnMAdd_submit.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnMAdd_submit.setForeground(new java.awt.Color(250, 250, 250));
        btnMAdd_submit.setText("Create A/c");
        btnMAdd_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAdd_submitActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(40, 0, 240));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Add New Member");

        jLabel40.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel40.setText("Date Of Joining");

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel41.setText("Type of Member");

        txtMAdd_doj.setEditable(false);
        txtMAdd_doj.setBackground(new java.awt.Color(230, 230, 230));
        txtMAdd_doj.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtMAdd_doj.setForeground(new java.awt.Color(20, 140, 20));
        txtMAdd_doj.setText("14-08-2019");
        txtMAdd_doj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAdd_dojActionPerformed(evt);
            }
        });

        txtMAdd_Name.setBackground(new java.awt.Color(215, 255, 255));
        txtMAdd_Name.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtMAdd_Name.setForeground(new java.awt.Color(20, 140, 20));
        txtMAdd_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAdd_NameActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel43.setText("Contact No. 1        :");

        txtMAdd_Ph1.setBackground(new java.awt.Color(215, 255, 255));
        txtMAdd_Ph1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtMAdd_Ph1.setForeground(new java.awt.Color(20, 140, 20));
        txtMAdd_Ph1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAdd_Ph1ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel44.setText("Contact No. 2        :");

        txtMAdd_Ph2.setBackground(new java.awt.Color(215, 255, 255));
        txtMAdd_Ph2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtMAdd_Ph2.setForeground(new java.awt.Color(20, 140, 20));
        txtMAdd_Ph2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAdd_Ph2ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel45.setText("Address                 :");

        txtMAdd_Addr.setBackground(new java.awt.Color(215, 255, 255));
        txtMAdd_Addr.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtMAdd_Addr.setForeground(new java.awt.Color(20, 140, 20));
        txtMAdd_Addr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAdd_AddrActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel46.setText("Joining Fee");

        jLabel47.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel47.setText("Protection Fee");

        chkMAdd_iss.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        chkMAdd_iss.setForeground(new java.awt.Color(20, 140, 20));

        jLabel48.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(20, 140, 20));
        jLabel48.setText(" Rs. 100/-");

        jLabel49.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(20, 140, 20));
        jLabel49.setText(" Rs. 500/-");

        jLabel50.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel50.setText("Issue a Book");

        comboMAdd.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboMAdd.setForeground(new java.awt.Color(20, 140, 20));
        comboMAdd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select type", "Student", "Staff" }));
        comboMAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMAddActionPerformed(evt);
            }
        });

        btnMAdd_bk.setBackground(new java.awt.Color(20, 140, 20));
        btnMAdd_bk.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnMAdd_bk.setForeground(new java.awt.Color(250, 250, 250));
        btnMAdd_bk.setText("Back");

        lblMAddErr.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblMAddErr.setForeground(new java.awt.Color(250, 0, 0));
        lblMAddErr.setText("Here Message will show...");

        btnMAdd_reset.setBackground(new java.awt.Color(20, 140, 20));
        btnMAdd_reset.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnMAdd_reset.setForeground(new java.awt.Color(250, 250, 250));
        btnMAdd_reset.setText("Reset");
        btnMAdd_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAdd_resetActionPerformed(evt);
            }
        });

        txtMAdd_Class.setBackground(new java.awt.Color(215, 255, 255));
        txtMAdd_Class.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtMAdd_Class.setForeground(new java.awt.Color(20, 140, 20));
        txtMAdd_Class.setToolTipText("This Field will Editable only when Student Type is Selected");
        txtMAdd_Class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAdd_ClassActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel73.setText("Roll No   :");

        jLabel74.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel74.setText(" Class                     :");

        txtMAdd_Rno.setBackground(new java.awt.Color(215, 255, 255));
        txtMAdd_Rno.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        txtMAdd_Rno.setForeground(new java.awt.Color(20, 140, 20));
        txtMAdd_Rno.setToolTipText("This Field will Editable only when Student Type is Selected");
        txtMAdd_Rno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAdd_RnoActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel75.setText("Member                 :");

        javax.swing.GroupLayout pnlMAddLayout = new javax.swing.GroupLayout(pnlMAdd);
        pnlMAdd.setLayout(pnlMAddLayout);
        pnlMAddLayout.setHorizontalGroup(
            pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMAddLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMAddLayout.createSequentialGroup()
                        .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(345, 345, 345))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMAddLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(309, 309, 309))
                    .addGroup(pnlMAddLayout.createSequentialGroup()
                        .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMAdd_Ph1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(333, 333, 333))
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addGap(161, 161, 161)
                                        .addComponent(txtMAdd_Class, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMAdd_Rno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMAddLayout.createSequentialGroup()
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMAdd_Addr, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMAdd_Ph2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addComponent(btnMAdd_bk, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btnMAdd_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnMAdd_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addGap(161, 161, 161)
                                        .addComponent(txtMAdd_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMAddLayout.createSequentialGroup()
                        .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMAddLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114)
                                        .addComponent(chkMAdd_iss)))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMAddLayout.createSequentialGroup()
                                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMAdd_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(212, 212, 212)))
                        .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlMAddLayout.createSequentialGroup()
                                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMAddLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboMAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 13, Short.MAX_VALUE)))
                        .addGap(193, 193, 193))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMAddLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMAddErr, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        pnlMAddLayout.setVerticalGroup(
            pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMAddLayout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMAddLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboMAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(pnlMAddLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMAdd_doj, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMAdd_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMAdd_Ph1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMAdd_Ph2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMAdd_Addr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMAdd_Rno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMAdd_Class, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chkMAdd_iss))
                .addGap(18, 18, 18)
                .addGroup(pnlMAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMAdd_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMAdd_submit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMAdd_bk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMAddErr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pnlBkRet.setBackground(new java.awt.Color(240, 51, 0));

        lblRetBook.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        lblRetBook.setForeground(new java.awt.Color(40, 0, 240));
        lblRetBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRetBook.setText("Return Book");

        pnlBk_R_A.setBackground(new java.awt.Color(220, 220, 220));

        pnlBkI_A_sub2.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_A_sub2.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_A_sub2.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_A_sub2.setText("Check");
        pnlBkI_A_sub2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_A_sub2ActionPerformed(evt);
            }
        });

        lblBkR_A_err.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkR_A_err.setForeground(new java.awt.Color(250, 0, 0));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel58.setText("Enter Member Id   :");

        lblBkR_A_Data.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBkR_A_Data.setForeground(new java.awt.Color(150, 150, 150));
        lblBkR_A_Data.setText("1002");
        lblBkR_A_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBkR_A_DataActionPerformed(evt);
            }
        });

        btnBkD_back7.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back7.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back7.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back7.setText("Back");
        btnBkD_back7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBk_R_ALayout = new javax.swing.GroupLayout(pnlBk_R_A);
        pnlBk_R_A.setLayout(pnlBk_R_ALayout);
        pnlBk_R_ALayout.setHorizontalGroup(
            pnlBk_R_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_ALayout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(pnlBk_R_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBk_R_ALayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblBkR_A_err, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBk_R_ALayout.createSequentialGroup()
                        .addComponent(btnBkD_back7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(pnlBkI_A_sub2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBkR_A_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        pnlBk_R_ALayout.setVerticalGroup(
            pnlBk_R_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_ALayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBkR_A_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBk_R_ALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_A_sub2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBkR_A_err, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel59.setText("Member Id : ");

        lblBk_R_B_mId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_mId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_B_mId.setText("1001");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel60.setText("Book Id   :");

        lblBk_R_B_bId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_B_bId.setText("10002");

        lblMIss_mName10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName10.setText("Member      :");

        lblBk_R_B_mNm.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_mNm.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_B_mNm.setText("Shubham sri");

        lblMIss_mName11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName11.setText("Book        :");

        lblBk_R_B_bNm.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bNm.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_B_bNm.setText("Visual Basic");

        lblMIss_mName12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName12.setText("Type            :");

        lblBk_R_B_mType.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_mType.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_B_mType.setText("Student");

        lblMIss_mName13.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName13.setText("Author     :");

        lblBk_R_B_bAuth.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bAuth.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_B_bAuth.setText("Martin Luthor");

        btnBkD_back8.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back8.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back8.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back8.setText("Cancel");
        btnBkD_back8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back8ActionPerformed(evt);
            }
        });

        pnlBkI_B_chgMem3.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_B_chgMem3.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_B_chgMem3.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_B_chgMem3.setText("Back");
        pnlBkI_B_chgMem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_B_chgMem3ActionPerformed(evt);
            }
        });

        pnlBkI_B_sub1.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_B_sub1.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_B_sub1.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_B_sub1.setText("Next");
        pnlBkI_B_sub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_B_sub1ActionPerformed(evt);
            }
        });

        lblMIss_mName14.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName14.setText("Issue Date :");

        lblBk_R_B_bIssDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bIssDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bIssDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_B_bIssDt.setText("Jul 23,2019");

        lblMIss_mName15.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName15.setText("      Last Date :");

        lblBk_R_B_bLastDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bLastDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bLastDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_B_bLastDt.setText("Aug 24,2019");

        lblMIss_mName16.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName16.setText("Returning a Book of - ");

        lblBk_R_B_bNm2.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bNm2.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bNm2.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_B_bNm2.setText("Java");

        lblMIss_mName17.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName17.setText("From");

        lblBk_I_D_mNm3.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_I_D_mNm3.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_I_D_mNm3.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_I_D_mNm3.setText("Shubham");

        lblBkR_B_err.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkR_B_err.setForeground(new java.awt.Color(250, 0, 0));
        lblBkR_B_err.setText("Error msg");

        jScrollPane6.setPreferredSize(new java.awt.Dimension(800, 600));

        listBkR_B.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listBkR_B.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listBkR_B.setPreferredSize(new java.awt.Dimension(1000, 800));
        listBkR_B.setSelectionBackground(new java.awt.Color(204, 253, 248));
        listBkR_B.setSelectionForeground(new java.awt.Color(0, 0, 0));
        listBkR_B.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listBkR_BValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(listBkR_B);

        lblMIss_mName18.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName18.setText("   Returning on :");

        lblBk_R_B_bRetDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bRetDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bRetDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_B_bRetDt.setText("Aug 24,2019");

        lblBk_R_B_bDelay.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bDelay.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bDelay.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_B_bDelay.setText("33 day(s) Late");

        javax.swing.GroupLayout pnlBk_R_BLayout = new javax.swing.GroupLayout(pnlBk_R_B);
        pnlBk_R_B.setLayout(pnlBk_R_BLayout);
        pnlBk_R_BLayout.setHorizontalGroup(
            pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_BLayout.createSequentialGroup()
                            .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                    .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                            .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblMIss_mName10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblMIss_mName12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblBk_R_B_mId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblBk_R_B_mNm, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                                .addComponent(lblBk_R_B_mType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblMIss_mName11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblMIss_mName13, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
                                        .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                            .addComponent(lblMIss_mName14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblBk_R_B_bIssDt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(38, 38, 38)
                                            .addComponent(lblMIss_mName15)))
                                    .addGap(10, 10, 10)
                                    .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblBk_R_B_bLastDt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                                .addComponent(lblBk_R_B_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))
                                            .addComponent(lblBk_R_B_bNm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblBk_R_B_bAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                    .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(lblMIss_mName16))
                                        .addComponent(btnBkD_back8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11)
                                    .addComponent(lblBk_R_B_bNm2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblMIss_mName17))
                                .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                    .addGap(113, 113, 113)
                                    .addComponent(lblMIss_mName18, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblBk_R_B_bRetDt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblBk_R_B_bDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(93, 93, 93))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_BLayout.createSequentialGroup()
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)))
                    .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                .addComponent(pnlBkI_B_chgMem3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(pnlBkI_B_sub1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblBkR_B_err, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_I_D_mNm3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        pnlBk_R_BLayout.setVerticalGroup(
            pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_BLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_BLayout.createSequentialGroup()
                        .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                .addComponent(lblBk_R_B_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBk_R_B_bNm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBk_R_B_mId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMIss_mName10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBk_R_B_mNm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMIss_mName12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBk_R_B_mType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMIss_mName11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBk_R_BLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMIss_mName13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBk_R_B_bAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(7, 7, 7)
                        .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMIss_mName15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_B_bLastDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMIss_mName14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBk_R_B_bIssDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMIss_mName18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_R_B_bRetDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_R_B_bDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMIss_mName16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_R_B_bNm2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMIss_mName17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_I_D_mNm3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBk_R_BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_B_sub1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_B_chgMem3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBkR_B_err, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlBk_R_C.setBackground(new java.awt.Color(220, 220, 220));

        btnBkD_back9.setBackground(new java.awt.Color(20, 180, 20));
        btnBkD_back9.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkD_back9.setForeground(new java.awt.Color(250, 250, 250));
        btnBkD_back9.setText("Cancel");
        btnBkD_back9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkD_back9ActionPerformed(evt);
            }
        });

        pnlBkI_B_chgMem4.setBackground(new java.awt.Color(20, 180, 20));
        pnlBkI_B_chgMem4.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        pnlBkI_B_chgMem4.setForeground(new java.awt.Color(250, 250, 250));
        pnlBkI_B_chgMem4.setText("Back");
        pnlBkI_B_chgMem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnlBkI_B_chgMem4ActionPerformed(evt);
            }
        });

        btnBkShow_Go5.setBackground(new java.awt.Color(20, 180, 20));
        btnBkShow_Go5.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnBkShow_Go5.setForeground(new java.awt.Color(250, 250, 250));
        btnBkShow_Go5.setText("Return Book");
        btnBkShow_Go5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkShow_Go5ActionPerformed(evt);
            }
        });

        lblBkR_C_err.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblBkR_C_err.setForeground(new java.awt.Color(250, 0, 0));
        lblBkR_C_err.setText("Error msg");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel61.setText("Member Id : ");

        lblBk_R_C_mId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_mId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_C_mId.setText("1001");

        jLabel67.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(40, 0, 240));
        jLabel67.setText("Return Book");

        lblBk_R_C_bId.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_bId.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_C_bId.setText("10002");

        lblMIss_mName19.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName19.setText("Member      :");

        lblBk_R_C_mNm.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_mNm.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_C_mNm.setText("Shubham sri");

        lblMIss_mName20.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName20.setText("Book        :");

        lblBk_R_C_bNm.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_bNm.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_C_bNm.setText("Visual Basic");

        lblMIss_mName21.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName21.setText("Type            :");

        lblBk_R_C_mType.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_mType.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_C_mType.setText("Student");

        lblMIss_mName22.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName22.setText(" Author     :");

        lblBk_R_C_bAuth.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_bAuth.setForeground(new java.awt.Color(20, 140, 20));
        lblBk_R_C_bAuth.setText("Martin Luthor");

        lblMIss_mName23.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName23.setText("Issue Date :");

        lblBk_R_C_bIssDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_C_bIssDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_bIssDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_C_bIssDt.setText("Jul 23,2019");

        lblMIss_mName24.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName24.setText("      Last Date  :");

        lblBk_R_C_bLastDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_C_bLastDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_bLastDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_C_bLastDt.setText("Aug 24,2019");

        lblMIss_mName25.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblMIss_mName25.setText("   Returning on :");

        lblBk_R_C_bRetDt.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_C_bRetDt.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_bRetDt.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_C_bRetDt.setText("Aug 24,2019");

        lblBk_R_C_bDelay.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_C_bDelay.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_bDelay.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_C_bDelay.setText("33 day(s) Late");

        comboBk_R_C.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        comboBk_R_C.setText("Charge Fine");
        comboBk_R_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBk_R_CActionPerformed(evt);
            }
        });

        pnlBkR_C_sub1.setBackground(new java.awt.Color(245, 245, 245));

        lblFineInfo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblFineInfo.setText("Fine for 32 Day(s)   :");

        lblFineCalc.setBackground(new java.awt.Color(230, 230, 230));
        lblFineCalc.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblFineCalc.setForeground(new java.awt.Color(255, 0, 0));
        lblFineCalc.setText("Rs 2 x 2");

        lblBk_R_C_1_Total.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_C_1_Total.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_C_1_Total.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_C_1_Total.setText("Rs 4");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel69.setText("Total                            :");

        btnRetBkRecv.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnRetBkRecv.setForeground(new java.awt.Color(255, 0, 0));
        btnRetBkRecv.setText("Receive");
        btnRetBkRecv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetBkRecvActionPerformed(evt);
            }
        });

        jLabel70.setBackground(new java.awt.Color(210, 210, 210));
        jLabel70.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(50, 100, 100));
        jLabel70.setText("Fine Details : ");

        javax.swing.GroupLayout pnlBkR_C_sub1Layout = new javax.swing.GroupLayout(pnlBkR_C_sub1);
        pnlBkR_C_sub1.setLayout(pnlBkR_C_sub1Layout);
        pnlBkR_C_sub1Layout.setHorizontalGroup(
            pnlBkR_C_sub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkR_C_sub1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkR_C_sub1Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(pnlBkR_C_sub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkR_C_sub1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRetBkRecv, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(pnlBkR_C_sub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlBkR_C_sub1Layout.createSequentialGroup()
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblBk_R_C_1_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlBkR_C_sub1Layout.createSequentialGroup()
                            .addComponent(lblFineInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblFineCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(137, 137, 137))
        );
        pnlBkR_C_sub1Layout.setVerticalGroup(
            pnlBkR_C_sub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkR_C_sub1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkR_C_sub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFineInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFineCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBkR_C_sub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBk_R_C_1_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnRetBkRecv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pnlBkR_C_sub2.setBackground(new java.awt.Color(245, 245, 245));

        radioR_C_inc.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        radioR_C_inc.setText("Increment");
        radioR_C_inc.setToolTipText("Need to Increase Last Date may be when there will be holiday(s) on Last Date");

        radioR_C_dec.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        radioR_C_dec.setText("Decrement");
        radioR_C_dec.setToolTipText("Need to Decrease Last Date may be when only few days left in end of Academic Year");
        radioR_C_dec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioR_C_decActionPerformed(evt);
            }
        });

        jLabel72.setBackground(new java.awt.Color(210, 210, 210));
        jLabel72.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(50, 100, 100));
        jLabel72.setText("Change Last Date :");

        txtBkRet_C_2_nDays.setBackground(new java.awt.Color(250, 250, 250));
        txtBkRet_C_2_nDays.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtBkRet_C_2_nDays.setText("0");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel53.setText("Reason   :");

        lblBk_R_B_bLastDt1.setBackground(new java.awt.Color(230, 230, 230));
        lblBk_R_B_bLastDt1.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        lblBk_R_B_bLastDt1.setForeground(new java.awt.Color(255, 0, 0));
        lblBk_R_B_bLastDt1.setText("Aug 24,2019");

        txtBkRet_C_2_reason.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBkRet_C_2_reason.setText("Because of ");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel68.setText("Day(s) in");

        javax.swing.GroupLayout pnlBkR_C_sub2Layout = new javax.swing.GroupLayout(pnlBkR_C_sub2);
        pnlBkR_C_sub2.setLayout(pnlBkR_C_sub2Layout);
        pnlBkR_C_sub2Layout.setHorizontalGroup(
            pnlBkR_C_sub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkR_C_sub2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkR_C_sub2Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBkR_C_sub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBkR_C_sub2Layout.createSequentialGroup()
                        .addComponent(txtBkRet_C_2_nDays)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lblBk_R_B_bLastDt1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBkR_C_sub2Layout.createSequentialGroup()
                        .addComponent(radioR_C_inc)
                        .addGap(69, 69, 69)
                        .addComponent(radioR_C_dec))
                    .addComponent(txtBkRet_C_2_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );
        pnlBkR_C_sub2Layout.setVerticalGroup(
            pnlBkR_C_sub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkR_C_sub2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlBkR_C_sub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioR_C_inc)
                    .addComponent(radioR_C_dec))
                .addGap(18, 18, 18)
                .addGroup(pnlBkR_C_sub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBk_R_B_bLastDt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBkR_C_sub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBkRet_C_2_nDays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnlBkR_C_sub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBkRet_C_2_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel71.setText("Book Id   :");

        javax.swing.GroupLayout pnlBk_R_CLayout = new javax.swing.GroupLayout(pnlBk_R_C);
        pnlBk_R_C.setLayout(pnlBk_R_CLayout);
        pnlBk_R_CLayout.setHorizontalGroup(
            pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(lblBkR_C_err, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMIss_mName19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMIss_mName21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblBk_R_C_mId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblBk_R_C_mNm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblBk_R_C_mType, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                        .addComponent(lblMIss_mName23, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblBk_R_C_bIssDt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel71)
                                            .addComponent(lblMIss_mName20, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                                .addComponent(lblBk_R_C_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))
                                            .addComponent(lblBk_R_C_bNm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(lblMIss_mName22, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(lblMIss_mName24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblBk_R_C_bLastDt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblBk_R_C_bAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(pnlBkR_C_sub1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                                        .addComponent(btnBkD_back9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93)
                                        .addComponent(pnlBkI_B_chgMem4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82)
                                        .addComponent(btnBkShow_Go5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pnlBkR_C_sub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBk_R_CLayout.createSequentialGroup()
                                        .addComponent(comboBk_R_C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(78, 78, 78)
                                        .addComponent(lblMIss_mName25, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblBk_R_C_bRetDt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblBk_R_C_bDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addGap(14, 14, 14)))))
                .addGap(0, 129, Short.MAX_VALUE))
            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel67)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBk_R_CLayout.setVerticalGroup(
            pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBk_R_CLayout.createSequentialGroup()
                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_C_mId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMIss_mName19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_C_mNm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBk_R_C_bId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBk_R_C_bNm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMIss_mName20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBk_R_CLayout.createSequentialGroup()
                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMIss_mName22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBk_R_C_bAuth, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMIss_mName23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBk_R_C_bIssDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMIss_mName24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblBk_R_C_bLastDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMIss_mName21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBk_R_C_mType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBk_R_C, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMIss_mName25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBk_R_C_bRetDt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblBk_R_C_bDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBkR_C_sub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkR_C_sub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(pnlBk_R_CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBkD_back9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBkShow_Go5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBkI_B_chgMem4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblBkR_C_err, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout pnlBkRetLayout = new javax.swing.GroupLayout(pnlBkRet);
        pnlBkRet.setLayout(pnlBkRetLayout);
        pnlBkRetLayout.setHorizontalGroup(
            pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkRetLayout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(lblRetBook)
                .addContainerGap(339, Short.MAX_VALUE))
            .addGroup(pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkRetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBk_R_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkRetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBk_R_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkRetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBk_R_C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlBkRetLayout.setVerticalGroup(
            pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBkRetLayout.createSequentialGroup()
                .addComponent(lblRetBook, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 497, Short.MAX_VALUE))
            .addGroup(pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkRetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBk_R_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkRetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBk_R_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlBkRetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBkRetLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBk_R_C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlReport.setBackground(new java.awt.Color(240, 241, 240));
        pnlReport.setPreferredSize(new java.awt.Dimension(900, 551));

        lblRetBook1.setFont(new java.awt.Font("Serif", 1, 34)); // NOI18N
        lblRetBook1.setForeground(new java.awt.Color(40, 0, 240));
        lblRetBook1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRetBook1.setText("Create Reports");

        checkRep_1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        checkRep_1.setText("List of All Issued Books that are Overdue    -  ");
        checkRep_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRep_1ActionPerformed(evt);
            }
        });

        checkRep_2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        checkRep_2.setText("List of Members whose Mem_ship Expires-");
        checkRep_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRep_2ActionPerformed(evt);
            }
        });

        checkRep_3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        checkRep_3.setText("List of All Members that are                           -  ");
        checkRep_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRep_3ActionPerformed(evt);
            }
        });

        checkRep_4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        checkRep_4.setText("List of All books that are                                     -");
        checkRep_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRep_4ActionPerformed(evt);
            }
        });

        comboRep1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRep1.setForeground(new java.awt.Color(20, 240, 20));
        comboRep1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Criteria", "At Given Date", "After This Date" }));

        comboRep2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRep2.setForeground(new java.awt.Color(20, 240, 20));
        comboRep2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Criteria", "At this Date", "Before a Date" }));

        comboRep3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRep3.setForeground(new java.awt.Color(20, 240, 20));
        comboRep3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Criteria", "Active Students", "Active Teachers", "Active Members", "Inactive Student", "Inactive Teacher", "Inactive Member", "All Members" }));
        comboRep3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRep3ActionPerformed(evt);
            }
        });

        comboRep4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRep4.setForeground(new java.awt.Color(20, 240, 20));
        comboRep4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Criteria", "Available", "Issued", "On Repairing", "Destroyed", "Select All Books" }));

        lblRepDt.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblRepDt.setText("Date(dd-mm-yyyy)  -- ");

        txtRepDD.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtRepDD.setForeground(new java.awt.Color(20, 240, 20));

        txtRepMM.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtRepMM.setForeground(new java.awt.Color(20, 240, 20));

        txtRepYYYY.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtRepYYYY.setForeground(new java.awt.Color(20, 240, 20));
        txtRepYYYY.setText("20");

        javax.swing.GroupLayout repSub1Layout = new javax.swing.GroupLayout(repSub1);
        repSub1.setLayout(repSub1Layout);
        repSub1Layout.setHorizontalGroup(
            repSub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, repSub1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRepDt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepDD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepMM, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepYYYY, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        repSub1Layout.setVerticalGroup(
            repSub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repSub1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(repSub1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRepDt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRepMM, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtRepYYYY, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtRepDD, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblRepDt2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblRepDt2.setText("Date(dd-mm-yyyy) -- ");

        txtRepDD2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtRepDD2.setForeground(new java.awt.Color(20, 240, 20));

        txtRepMM2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtRepMM2.setForeground(new java.awt.Color(20, 240, 20));

        txtRepYYYY2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtRepYYYY2.setForeground(new java.awt.Color(20, 240, 20));
        txtRepYYYY2.setText("20");

        javax.swing.GroupLayout repSub2Layout = new javax.swing.GroupLayout(repSub2);
        repSub2.setLayout(repSub2Layout);
        repSub2Layout.setHorizontalGroup(
            repSub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, repSub2Layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addComponent(lblRepDt2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRepDD2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepMM2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRepYYYY2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        repSub2Layout.setVerticalGroup(
            repSub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repSub2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(repSub2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRepDt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRepYYYY2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtRepMM2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtRepDD2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        reportSubmit.setBackground(new java.awt.Color(20, 180, 20));
        reportSubmit.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        reportSubmit.setForeground(new java.awt.Color(250, 250, 250));
        reportSubmit.setText("Print Report");
        reportSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportSubmitActionPerformed(evt);
            }
        });

        reportErr.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        reportErr.setForeground(new java.awt.Color(250, 0, 0));
        reportErr.setText("Error msg ");

        reportReset.setBackground(new java.awt.Color(20, 180, 20));
        reportReset.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        reportReset.setForeground(new java.awt.Color(250, 250, 250));
        reportReset.setText("Reset All");
        reportReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportResetActionPerformed(evt);
            }
        });

        comboRepSort1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRepSort1.setForeground(new java.awt.Color(20, 240, 20));
        comboRepSort1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort By Book", "Sort By Member", "Sort By LastDate" }));

        comboRepSort2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRepSort2.setForeground(new java.awt.Color(20, 240, 20));
        comboRepSort2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort By Name", "By Days Left" }));

        comboRepSort3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRepSort3.setForeground(new java.awt.Color(20, 240, 20));
        comboRepSort3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort by Name", "Sort by Class", "Sort by Id", "Sort-Last Seen" }));

        comboRepSort4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        comboRepSort4.setForeground(new java.awt.Color(20, 240, 20));
        comboRepSort4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort By Date", "Sort By Cost", "Sort By Rack", "By Book Id", "" }));

        btnReportBack.setBackground(new java.awt.Color(20, 180, 20));
        btnReportBack.setFont(new java.awt.Font("Serif", 1, 20)); // NOI18N
        btnReportBack.setForeground(new java.awt.Color(250, 250, 250));
        btnReportBack.setText("Back");
        btnReportBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReportLayout = new javax.swing.GroupLayout(pnlReport);
        pnlReport.setLayout(pnlReportLayout);
        pnlReportLayout.setHorizontalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReportLayout.createSequentialGroup()
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlReportLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(repSub1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlReportLayout.createSequentialGroup()
                                    .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(checkRep_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(checkRep_3, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(reportReset, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboRep3, 0, 1, Short.MAX_VALUE)
                                        .addComponent(comboRep4, 0, 157, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboRepSort4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboRepSort3, 0, 147, Short.MAX_VALUE))))
                            .addGroup(pnlReportLayout.createSequentialGroup()
                                .addComponent(checkRep_1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboRep1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboRepSort1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReportLayout.createSequentialGroup()
                                .addComponent(checkRep_2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboRep2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboRepSort2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlReportLayout.createSequentialGroup()
                        .addGap(0, 132, Short.MAX_VALUE)
                        .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlReportLayout.createSequentialGroup()
                                .addComponent(btnReportBack, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(reportSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(repSub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(129, 129, 129))
            .addGroup(pnlReportLayout.createSequentialGroup()
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReportLayout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(lblRetBook1))
                    .addGroup(pnlReportLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(reportErr, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlReportLayout.setVerticalGroup(
            pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportLayout.createSequentialGroup()
                .addComponent(lblRetBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkRep_1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRep1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRepSort1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repSub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkRep_2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRep2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRepSort2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repSub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkRep_3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRep3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRepSort3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkRep_4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRep4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboRepSort4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnlReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportErr, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout pnlParentLayout = new javax.swing.GroupLayout(pnlParent);
        pnlParent.setLayout(pnlParentLayout);
        pnlParentLayout.setHorizontalGroup(
            pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(pnlParentLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(pnlBkShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkEditNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDelNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlParentLayout.setVerticalGroup(
            pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBkShow, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkIssue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkEditNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDelNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkRet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel_D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pnlParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlParentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlBkDel_E, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlParentBtns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlParentBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
