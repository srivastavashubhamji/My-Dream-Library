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

        private void btnBkAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBkAddActionPerformed
        // Clearing the Text Fields of "Add New Book Panel" and Display that Panel...
            
            clearFields(allBkAddTxt);
            showOnlyPanel("pnlBkAdd");
            allBkAddTxt[8].setText("-");    // txtBkAuth2
            allBkAddTxt[9].setText("-");    // txtBkAbout        
            lblBkErrSucc.setVisible(false);
        }

        private void btnBkIssueActionPerformed(java.awt.event.ActionEvent evt) {
        // This method will invoked when All the Fields are filled and Submit Clicked to create new Book(s)...
            
            try {
                lblBkI_A_err.setForeground(Color.red);
                lblBkI_A_Data.setText("");
                if (isMemShipExpUpdated == -1 || isMemShipExpUpdated == -2) {
    //          SQLExc... || Exc... occured 
    //              p("SQLExc... || Exc... occured in chk_UpdtMem_ship( ) , isMemShipExpUpdated = " + isMemShipExpUpdated);
                    isMemShipExpUpdated = check_UpdateExpiryOfMem_ship();
    //              p("Again Trying...chk(), isMemShipExpUpdated = " + isMemShipExpUpdated);
                    if (isMemShipExpUpdated == -1 || isMemShipExpUpdated == -2) {
                        //             Membership Not Updated...
                        lblBkI_A_err.setVisible(true);
                        lblBkI_A_err.setText("OOPs...Connection Failed, Re-Start MySql Database !");
                        lblBkI_A_Data.setEditable(false);
                        lblBkI_A_Data.setToolTipText("Restart MySQL Database to Enter the Member Id for Issuing book.");
                    }
                } else {
    //             This Time Membership Updated...SUCCESFULLY
                    lblBkI_A_err.setVisible(false);
                    lblBkI_A_err.setText("");
                    lblBkI_A_Data.setEditable(true);
                    lblBkI_A_Data.setToolTipText("Enter the Member Id for Issuing book.");
                }
                showOnlyPanel("pnlBkIssue");
                pnlBkI_B.setVisible(false);
                pnlBkI_C.setVisible(false);
                pnlBkI_D.setVisible(false);
                pnlBkI_A.setVisible(true);
                btnBkI_A_show.setVisible(false); // Display when The Enter mem Already Took One/More Books
            } catch (Exception e) {

            }
        }
        private void btnBkAddSaveActionPerformed(java.awt.event.ActionEvent evt) {
	// This method will run when New Book data was entered and submitted to Save...
	
        String bkName = txtBkName.getText();
        String bkType = txtBkType.getText();
        String bkRack = txtBkRack.getText();
        String bkAuth1 = txtBkAuth1.getText();
        String bkPub = txtBkPub.getText();
        String bkQty = txtBkQty.getText();
        String bkPrice = txtBkPrice.getText();
        String bkPages = txtBkPages.getText();
        String bkAuth2 = txtBkAuth2.getText();
        String bkAbout = txtBkAbout.getText();
        int validNo = 0;
		
        Connection con = null;
        CallableStatement st = null;
        Statement stmt = null;
        ResultSet rs = null;
        int newAccId = 0;
        
        try {
            // Checking For Empty Feilds ...
            if (isEmptyFields(allBkAddTxt) == true) {
                lblBkErrSucc.setForeground(Color.red);
                lblBkErrSucc.setVisible(true);
                throw new Exception("OOPs... Some Fields are Empty.");  // Err_msg

                // Checking For Valid Feilds ...
            } else if ((validNo = isInvalidBkAddFields()) != 0) {
                //allBkAddTxt = new JTextField[]{txtBkName,txtBkType,txtBkRack,txtBkAuth1,txtBkPub,txtBkQty,
                //              txtBkPrice,txtBkPages,txtBkAuth2,txtBkAbout};
                lblBkErrSucc.setForeground(Color.red);
                lblBkErrSucc.setVisible(true);
                throw new Exception("OOPs... Some Fields are Invalid.");  // Err_msg

                // Inserting Feilds Data ...
            } else {
                con = getDbConnObj();
                if (con == null) {
                    lblBkErrSucc.setForeground(Color.red);
                    lblBkErrSucc.setVisible(true);
                    throw new Exception("OOPs... Something Went Wrong.Retry");  // Err_msg
                }
                int pg = Integer.parseInt(bkPages);
                int rack = Integer.parseInt(bkRack);
                int qty = Integer.parseInt(bkQty);
                double price = Double.parseDouble(bkPrice);
                int countedAccIds = -1, maxAccNums = 100 + qty;

                String sql = "Select count(distinct b_acc_id) as totalDistinctBooks from tbl_book_info ";
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);

                try {
				// Pointer now points from Row = -1 to Row = 0
                    rs.next();
                    countedAccIds = rs.getInt("totalDistinctBooks");
                    p(countedAccIds + " records are in tbl_book_info <--2)");
                } catch (Exception e) {
                    lblBkErrSucc.setForeground(Color.red);
                    lblBkErrSucc.setVisible(true);
                    showMsgOnLbl("OOPs... Something went Wrong.Retry !", lblBkErrSucc);
                    return;
                }
                // Initially, newAccId = 10001, after 3 rows newAccId = 10001 + 3:=> newAccId = 10004
                newAccId = (10001 + countedAccIds);

                sql = "INSERT INTO `tbl_book_info`(`b_acc_id`, `b_name`, `b_qty`, `b_type`, `b_auth1`, `b_auth2`,`b_pub`, `b_pages`, `b_rack`, `b_price`, `b_about`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

                con = getDbConnObj();
                PreparedStatement stmtPrep = con.prepareStatement(sql);
                stmtPrep.setInt(1, newAccId);
                stmtPrep.setString(2, bkName);
                stmtPrep.setInt(3, qty);

                stmtPrep.setString(4, bkType);
                stmtPrep.setString(5, bkAuth1);

                stmtPrep.setString(6, bkAuth2);
                stmtPrep.setString(7, bkPub);

                stmtPrep.setInt(8, pg);
                stmtPrep.setInt(9, rack);

                stmtPrep.setDouble(10, price);
                stmtPrep.setString(11, bkAbout);

                int affectedRows = -1;
                try {
                    stmtPrep.execute();

                } catch (Exception e) {
                    p("Exception occured 9020,e.getMessage()" + e.getMessage());
					affectedRows=0;
                }
                p("4) Exe..d sql , aff = " + affectedRows);
                if (affectedRows == 0) {
                    lblBkErrSucc.setForeground(Color.red);
                    lblBkErrSucc.setVisible(true);
                    p("5) could not add Book... throw");
                    throw new Exception("OOPs, Could Not Add Book...Retry !");
                } else {
                    // Till Now A new Book is Added in   Books Information Table     ...
                    // ... Now insert the Copies (Qty.) in 'Books Table->tbl_books' by calling a Procedure 'insBooks(?,?)' ...                    
					
                    st = null;
                    st = con.prepareCall("{call insBooks(?,?)}");                    

                    for(int i = 1; i <= qty; i++){
                    // By Default Each books Accession Num starts with 101 ...
						int accNum = 100 + i;

                        st.setInt(1, newAccId);
                        st.setInt(2, accNum);
                        st.addBatch();
                    }

                    int[] result = st.executeBatch();

                    if (result.length != qty) {
				    //  All Copies could not Saved...
					
                        lblBkErrSucc.setForeground(Color.red);
                        lblBkErrSucc.setVisible(true);
                        throw new Exception("OOPs, Only " + (result.length) + " books saved, Retry with "
                                + (qty - result.length) + " Qty of '" + bkName + "'");
                    } else {
                        lblBkErrSucc.setForeground(new Color(20, 180, 20));
                        lblBkErrSucc.setVisible(true);
                        showMsgOnLbl("Great...Book '" + bkName + "'(" + bkQty + ") Saved Successfully.", lblBkErrSucc);
                        clearFields(allBkAddTxt);
                    }
                }
            }
        } catch (Exception e) {
		// Showing Feedback of Book saving Process...
            showMsgOnLbl(e.getMessage(), lblBkErrSucc);
        } finally {
            try {
                st.close();
                stmt.close();
                rs.close();
                con.close();
            } catch (Exception e) {

            }
        }
    }

    private void btnBkShowActionPerformed(java.awt.event.ActionEvent evt) {
    // This Panel will visible when 'Book Show' button will display...
		showOnlyPanel("pnlBkShow");

        lblBkShowErr.setVisible(false);
        JLabel[] allShowBkSuccLbl = {lblBkShowTotalBk, lblBkShowNBks,
            lblBkShowBkQty, lblBkShowNBkQty,
            lblBkShowBkStsA, lblBkShowNBkStsA,
            lblBkShowBkStsI, lblBkShowNBkStsI,
            lblBkShowBkStsR, lblBkShowNBkStsR
        };

        for (JLabel temp : allShowBkSuccLbl) {
            temp.setForeground(new Color(20, 180, 20));
            temp.setVisible(true);
        }
        try {
            listBkShow.setModel(
                    new javax.swing.AbstractListModel<String>() {
                String[] strings = getBooksRecords();

                public int getSize() {
                    return strings.length;
                }

                public String getElementAt(int i) {
                    return strings[i];
                }
            }); // Anonymouse class concept is used here, an Obj of javax.swing.AbstractListModel<String> was created and passed...
        } catch (Exception e) {

      }
   }
       private void btnBkAdvEditActionPerformed(java.awt.event.ActionEvent evt) {
        showOnlyPanel("pnlBkEdit");
        txtBkEdit_find.setText("");
        lblBkEditErr.setVisible(false);
//        String data = txtBkEdit_find.getText();        
//        String sql = "",typeOfSearch="";
//        try{
//                Connection con = getDbConnObj();
//                Statement st = con.createStatement();
//                ResultSet rs = st.executeQuery(sql);
//                if(rs == null){
//                    throw new Exception("OOPs... No such "+typeOfSearch+" Found, Retry !");
//                }else{
//                    try{
// //                      p("shifting Record Pointer ...");
//                       rs.next();
//                       String bid = ""+rs.getInt("b_acc_id");                       
//                       String bname = ""+rs.getString("b_name");
//                       String bqty = ""+rs.getInt("b_qty");
//                       String btype = rs.getString("b_type");
//                       String bauth1 = rs.getString("b_auth1");
//                       String bauth2 = ""+rs.getString("b_auth2");
//                       String bpub = rs.getString("b_pub");
//                       String bpages = ""+rs.getInt("b_pages");
//                       String brack = ""+rs.getInt("b_rack");
//                       String bprice = ""+rs.getDouble("b_price");
//                       String babout = rs.getString("b_about");
// //                       p("========= DATA TO BE EDITED  ========= ");
// //                    p(bid +" AND "+ bname +" AND "+ bqty +" AND "+ btype  +" AND "+ bauth1  +" AND "+ 
//                         bauth2  +" AND "+ bpub  +" AND "+ bpages  +" AND "+ brack  +" AND "+ bprice  +" AND "+ 
//                         babout );
//                    }catch(SQLException ex){
//                        throw new Exception("No such "+typeOfSearch+" found, Retry!");
//                    }
//                    catch(Exception e)
//                    {
//                        lblBkEditErr.setVisible(true);
//                        showMsgOnLbl(e.getMessage(),lblBkEditErr);
//                    }
//                }
//            }catch(Exception e){
//                lblBkEditErr.setVisible(true);
//                showMsgOnLbl(e.getMessage(),lblBkEditErr);
//            }

    }

    private void btnBkShow_GoActionPerformed(java.awt.event.ActionEvent evt) {		
	
    // This method will invoked WHEN Book Id / Name / AuthorName / Type was given and Submitted to fetch the Books related to the given Information...
		
		showOnlyPanel("pnlBkEdit");
        lblBkEditErr.setVisible(false);
        String data = txtBkEdit_find.getText();
        String sql = "", typeOfSearch = "";
        try {
            if (data.equals("")) {
	// ("empty field");
                throw new Exception("OOps...Field is Empty !");
            }
            if (data.matches("^\\d+$")) {
                //            p("This is in 'Id' Forma");
                sql = "Select * from tbl_book_info where b_acc_id = " + data;
                typeOfSearch = "Book Id";
            } else {
                //            p("This is in 'Book Name' Format");
                sql = "Select * from tbl_book_info where b_name like '%" + data + "%';";
                typeOfSearch = "Book Name";
            }
            Connection con = getDbConnObj();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs == null || rs.next() == false) {
                throw new Exception("OOPs... No such " + typeOfSearch + " Found, Retry !");
            } else {
                rs.getInt("b_acc_id");
                showOnlyPanel("pnlBkEditNow");
			// Set 'Reason Behind Del. ' by default to "Member Lost the Book" and "Show appropriate panel"                        
                takeDataToSetEdit(rs); // Passing 'ResultSet' to fill the fields for Updation of Book 
            }
        } catch (Exception e) {
            lblBkEditErr.setVisible(true);
            showMsgOnLbl(e.getMessage(), lblBkEditErr);
        }
    }

    private void btnBkReturnActionPerformed(java.awt.event.ActionEvent evt) {		
	// This method will invoked when "Book Return" Button will Clicked...	
        showOnlyPanel("pnlBkRet");
        lblBkR_A_Data.setText("");
        pnlBk_R_B.setVisible(false);
        pnlBk_R_C.setVisible(false);
        pnlBk_R_A.setVisible(true);
        lblBkR_A_err.setForeground(new Color(255, 0, 0));
        lblBkR_A_err.setText("");
    }
        private void btnBkRemoveActionPerformed(java.awt.event.ActionEvent evt) {
	// This method will display a Book Deletion Panel WHEN "Book Delete" button will clicked...
        showOnlyPanel("pnlBkDel");
        lblBkD_errMsg.setText("  ");
    }

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {

        showOnlyPanel("pnlReport");
        if (isMemShipExpUpdated == -1 || isMemShipExpUpdated == -2)
		// -1 Represents : This method didn't Updated mStatus of mem_ship...
            isMemShipExpUpdated = check_UpdateExpiryOfMem_ship();
			
		resetReportComps();
		// p("Report clicked actions were performed");
    }

    private void btnBkE_backActionPerformed(java.awt.event.ActionEvent evt) {
	// This method is invoked when 'Back' button clicked...
        showOnlyPanel("pnlBkEdit");
        txtBkEdit_find.setText("");
        lblBkEditErr.setVisible(false);
    }
    private void btnBkE_updateActionPerformed(java.awt.event.ActionEvent evt) {
	
	// This method will run when "Update Book" information Button will clicked...
        String calcId = lblBkE_id.getText();
		// As, Prev. Panel's Label contains-->"Id : 10001" ...
        int bkId = Integer.parseInt(calcId.substring(5));
        String bkName = txtBkE_name.getText();
        String bkType = txtBkE_type.getText();
        String bkRack = txtBkE_rack.getText();
        String bkAuth1 = txtBkE_auth1.getText();
        String bkPub = txtBkE_pub.getText();
        String bkQty = txtBkE_qty.getText();
        String bkPrice = txtBkE_price.getText();
        String bkPages = txtBkE_pages.getText();
        String bkAuth2 = txtBkE_auth2.getText();
        String bkAbout = txtBkE_about.getText();

        int validNo = 0;
        Connection con = null;
        CallableStatement st = null;
        Statement stmt = null;
        ResultSet rs = null;
        int newAccId = 0;
        p("1) Update clicked");
        try {
            // Checking For Empty Feilds ...
            allBkAddTxt = new JTextField[]{txtBkE_name, txtBkE_type, txtBkE_rack, txtBkE_auth1, txtBkE_auth2,
                txtBkE_pub, txtBkE_about, txtBkE_qty, txtBkE_price, txtBkE_pages};

            // p("checking isEmptyFields() ...");
            if (isEmptyFields(allBkAddTxt) == true) {
                lblBkEditNowErr.setVisible(true);
                throw new Exception("OOPs... Some Fields are Empty, Retry!");  // Err_msg

            }
            // p("checking isInvalidBkEditFields() ...");
            if ((validNo = isInvalidBkEditFields()) != 0) {
				
                lblBkEditNowErr.setVisible(true);
                lblBkEditNowErr.setVisible(true);
                throw new Exception("OOPs... Some Fields are Invalid, Retry!");  // Err_msg

			// Inserting Feilds Data ...
            } else {
                con = getDbConnObj();
                if (con == null) {
                    lblBkEditNowErr.setVisible(true);
                    throw new Exception("OOPs... Something Went Wrong, Retry!");  // Err_msg
                }
                int pg = Integer.parseInt(bkPages);
                int rack = Integer.parseInt(bkRack);
                double price = Double.parseDouble(bkPrice);

                String sql = "UPDATE `tbl_book_info` SET b_name = ?, b_type = ?,b_auth1 = ?,b_auth2 = ?, b_pub = ?, b_pages = ?,"
                        + "b_rack = ?, b_price = ?, b_about = ? where b_acc_id=?";

                con = getDbConnObj();
				//  p("Conn Created ...");
                PreparedStatement stmtPrep = con.prepareStatement(sql);

                stmtPrep.setString(1, bkName);
                // p(") one");
                stmtPrep.setString(2, bkType);
                // p(") two");
                stmtPrep.setString(3, bkAuth1);
                // p(") Three");
                stmtPrep.setString(4, bkAuth2);
                // p(") Four");
                stmtPrep.setString(5, bkPub);
                // p(") Five");
                stmtPrep.setInt(6, pg);
                // p(") Six");
                stmtPrep.setInt(7, rack);
                // p("4) seven");
                stmtPrep.setDouble(8, price);
                // p("4) eight");
                stmtPrep.setString(9, bkAbout);
                // p(") Nine");
                stmtPrep.setInt(10, bkId);
                int affectedRows = -1;
                try {
                    stmtPrep.execute();
                } catch (Exception e) {
                // p("Exception occured e.getMessage()" + e.getMessage());

                }
                // p("4) Exe..d sql , aff = " + affectedRows);
                if (affectedRows == 0) {
                    lblBkEditNowErr.setVisible(true);
                //  p("5) could not add Book... throw");
                    throw new Exception("OOPs...Book Details was not Update, Retry !");
                } else {
                    lblBkEditNowErr.setVisible(true);
                    lblBkEditNowErr.setForeground(new Color(20, 140, 20));
                    lblBkEditNowErr.setText("Great...Book Details Updated !");
                }
            }
        } catch (Exception e) {
            lblBkEditNowErr.setVisible(true);
            showMsgOnLbl(e.getMessage(), lblBkErrSucc);
        } finally {
            try {
                st.close();
                stmt.close();
                rs.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }
        private void btnBkE_showBksActionPerformed(java.awt.event.ActionEvent evt) {	// This method will call when Book will ready to display...
        showOnlyPanel("pnlBkShow");

        lblBkShowErr.setVisible(false);
        JLabel[] allShowBkSuccLbl = {lblBkShowTotalBk, lblBkShowNBks,
            lblBkShowBkQty, lblBkShowNBkQty,
            lblBkShowBkStsA, lblBkShowNBkStsA,
            lblBkShowBkStsI, lblBkShowNBkStsI,
            lblBkShowBkStsR, lblBkShowNBkStsR
        };

        for (JLabel temp : allShowBkSuccLbl) {
            temp.setForeground(new Color(20, 180, 20));
            temp.setVisible(true);
        }

        listBkShow.setModel(new javax.swing.AbstractListModel<String>() {
			
            String[] strings = getBooksRecords();

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    private void btnBkD_delActionPerformed(java.awt.event.ActionEvent evt) {// This method will calleded when Book Delete Panel A : "pnlBkDel" is Submitted ...
        
        showOnlyPanel("pnlBkDel");
        lblBkD_errMsg.setText("  ");
        String data = txtBkD_data.getText();
        String sql, inFix, typeOfSearch;
        int flagForTypeOfSearch;
        try {
            if (data.equals("")){
                lblBkD_errMsg.setText("  ");
                throw new Exception("OOps...Field is Empty !");
            }
            if (data.matches("^\\d+$")) {
                typeOfSearch = "Book Id";
                flagForTypeOfSearch = 1;
            } else {
			// p("This is in 'Book Name' Format");
                typeOfSearch = "Book Name";
                flagForTypeOfSearch = 2;
            }
            if (flagForTypeOfSearch == 1)                
                inFix = "WHERE a.b_acc_id = "+ data +" Group by a.b_acc_id Order by a.b_name ; ";
            else
                inFix = "WHERE a.b_name like '%"+ data +"%' and a.b_acc_id = b.accid Group by a.b_acc_id Order by a.b_name ; ";

			/* Fetched record(s) would look like this tabular structure...
				Select a.b_acc_id Code , a.b_name Name, a.b_qty Qty , a.b_type 'Type' , a.b_auth1 Author , a.b_price Price ,(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'I' ) Issued,(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'R' ) Repairing,(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'D' ) Destroyed,(select count(*) from tbl_books b where b.accid = a.b_acc_id  and b.status = 'A') Available From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid  WHERE a.b_acc_id =10001 Group by a.b_acc_id;
                +-------+-----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
                | Code  | Name      | Qty | Type        | Author | Price  | Issued | Repairing | Destroyed | Available |
                +-------+-----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
                | 10001 | Java book |   3 | Programming | lala   | 799.00 |      1 |         0 |         0 |         2 |
                +-------+-----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+        */
            sql = "Select a.b_acc_id Code , a.b_name Name, a.b_qty Qty , a.b_type 'Type' , a.b_auth1 Author , a.b_price Price , "+
                  "	(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'I' ) Issued, "+
                  "	(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'R' ) Repairing, "+
                  "	(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'D' ) Destroyed, "+
                  "	(select count(*) from tbl_books b where b.accid = a.b_acc_id  and b.status = 'A') Available  "+
                  "From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid  "+ inFix ;
            // p("Delete Book Sql 1 : \n"+sql);
            
            Connection con = getDbConnObj();
            if (con == null) {
                lblBkD_errMsg.setText("  ");
                throw new Exception("OOPs...Connection Problem, Check & Retry !");
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs == null || rs.next() == false) {
                lblBkD_errMsg.setText("  ");
                throw new Exception("OOPs... No such " + typeOfSearch + " Found, Retry !");
            }

            if( ! setDataOnBkDelPanel_B(rs) ){
			/** This ^ method will fetch  --> Row (if Only AccId is entered OR flagForTypeOfSearch == 1)          OR
										  --> Rows (if BookName is entered OR flagForTypeOfSearch == 2)
							 AND set Data --> bkDelPanel_C (if Only AccId is entered OR flagForTypeOfSearch == 1) OR
										  --> bkDelPanel_B (if BookName is entered OR flagForTypeOfSearch == 2) than select One of Those Fetched Books & set on pnl_C    */
                lblBkD_errMsg.setText("  ");
                lblBkD_errMsg.setText("OOPs, Data could Not Fetched Properly, Re-Enter Id !");
            }
            // Till here all went well...Data rel. to Entered 'bkAccId/bkName' set on pnlBkDel_B, now show that pnl...
            showOnlyPanel("pnlBkDel_B");
            
        } catch (Exception e) {
            lblBkD_errMsg.setText("  ");
            showMsgOnLbl(e.getMessage(), lblBkD_errMsg);
        }
    }

    private void btnBkD_backActionPerformed(java.awt.event.ActionEvent evt) {
        // To show Default Panel with This button ...i.e. Logo 
        showOnlyPanel("pnlLogo");
    }

    private void btnBkD_back2ActionPerformed(java.awt.event.ActionEvent evt) {
        // To show Default Panel with This button  ...i.e. Logo
        showOnlyPanel("pnlLogo");
    }

    private void btnBkDel_E_backActionPerformed(java.awt.event.ActionEvent evt) {
        // To show Default Panel with This button ...i.e. Logo
        showOnlyPanel("pnlBkDel_B");
    }

    private void btnBkDel_EActionPerformed(java.awt.event.ActionEvent evt) {
        // This is Called when "Book Deletion's SubPanel C     "pnlBkDelNow"    is Submitted" ...

    // If (MemLost Selected and textField is Not Null){}
        try {
            if (lblBkDelE_rbtnMem.isSelected()) {
                /*
				
				Next Steps...
				*) What we know : 	Member(m_id) Lost Book(accid), So
					1)  If Accid of Selected Book is Matched with...
						Books Issued to this Member(m_id)...
							Than : Set that Books data on Directly at 'Final Panel E'.
						Else
							All the Books issued To That Member would display in a List...
					2)  For Deletion, Appropriate book would be chosen and submitted for next Panel...
					3)  When Final Panel is Submitted (that means : Delete this Book 	or say...)
						a)	Turn the Status of That Book to 'D' in Tbl_books,
						b)  Make Entry of 'M_id', 'Accid', 'Accno', 'CurrDate' in Table 'bkDel',
						c)  Update " 'Accid' and 'Accno'"  in Table bktrans...
				*/
				
				//  Selected Accid is in :- lblBkDelE_Bid : PnlBkDel_C has "Book Id : 10001"                
                String accid = lblBkDelE_Bid.getText().substring(10);
                String mId = txtBkDel_E_mid.getText();
                if ( !(mId.matches("^\\d+$")) )
                    throw new Exception("OOPs... Invalid Member Id, Retry !");
                
                // String feedbk = checkIssuedNdSetOnPnl( mId );
                handleAccidIssuedTo( accid, mId );
                
            }   // if ( 'Other Reason' Selected and Text Area is Not null and with proper Explained Reason )
            else if (lblBkDelE_rbtnOth.isSelected()) {
			/*  Next Steps...
					1) Take Reason from TextArea and
					   All Data in String Array from ArrList...
					2) Insert into Table 'tbl_book_del' with fields 'Accid, Accno, Reason, Date' insert karo...
			*/

                String []arrBkDel = (listBkRet.get(listBkDel_B.getSelectedIndex())).split("([\\^\\^\\^]+)");            // Explaination...At the time of Submission , Whatever index is selected in pnlBkDel_B... Fetch the Value from Global ListObject 'listBkRet' by .get(n) using Corresponding Index No, Use split() method to Store that Concatenated String into a String Array...
                String reason = txtAreaBkDel_E.getText();																
                int accid = Integer.parseInt(arrBkDel[0]);

                if ((txtAreaBkDel_E.getText().length() < 11))
                    throw new Exception("Kindly Feed Properly Explained Reason ...!");
                
                if (txtAreaBkDel_E.getText().length() > 100)
                    throw new Exception("Kindly Feed Reason with Few Lesser words ...!");                
                                                                                                                        //p("\n%%%%% back Step 0- calling getAccnoFor( other....tion, accid = "+accid+")");
                String accno = getAccnoFor("OtherReasonOfBookDeletion", accid );
                if( ! accno.matches("^\\d+$"))                                                                          //If "102" like String Not Returned then the "customExceptionMessage" is returned ...
                    throw new Exception(accno);
				//  Further steps :-
				// 		Update tbl_books set Status -> 'D'eleted,
				// 		Insert into Table tableBookDeleted with Fields Accid, Accno, Reason, DelDate=getDbInsertableDate()...
                String updateFeedbk = updateStatusInTblBooks(accid,Integer.parseInt(accno));
                if( ! updateFeedbk.equals("tbl_books is Updated Successfully"))
                    throw new Exception( updateFeedbk);
                
                updateFeedbk = insertIntoTblBookDel(accid,Integer.parseInt(accno),"otherMemberSelected");
                if( ! updateFeedbk.equals("Table bkDel is Updated Successfully"))
                    throw new Exception( updateFeedbk);
                lblBkD_errMsg.setForeground(new Color(240,255,255));
                lblBkD_errMsg.setText("  ");
                lblBkD_errMsg.setText("A Book ["+ accid +"] is Successfully Deleted because - "+ reason);
                showOnlyPanel("pnlBkDel");
                

            }
        } catch (SQLException e) {
        //  p("OOPs,SQLException e occured ok");
            lblBkDel_E_Err.setVisible(true);
            lblBkDel_E_Err.setText("OOPs...Something Went Wrong, Retry !");
        } catch (Exception e) {
        //     p("OOPs,Exception e occured okok");
            lblBkDel_E_Err.setVisible(true);
            showMsgOnLbl(e.getMessage(), lblBkDel_E_Err);
        }

    }

    private void lblBkDelE_rbtnMemActionPerformed(java.awt.event.ActionEvent evt) {
        // Method will called when Book Delete SubPanel D is submitted...
        btnBkDel_E.setText("Check");
        pnlBkDelE_m.setVisible(true);
        pnlBkDelE_o.setVisible(false);
    }

    private void lblBkDelE_rbtnOthActionPerformed(java.awt.event.ActionEvent evt) {
        // Method to Save and Delete
        btnBkDel_E.setText("Save & Delete");
        pnlBkDelE_m.setVisible(false);
        pnlBkDelE_o.setVisible(true);
    }
	
    private void btnMAdd_submitActionPerformed(java.awt.event.ActionEvent evt) {//  This method is to Add the Member...
	
        try {
            boolean issueBkAfterRegister = false;
            String mName = txtMAdd_Name.getText();
            String mPh1 = txtMAdd_Ph1.getText();
            String mPh2 = txtMAdd_Ph2.getText();
            String mAddr = txtMAdd_Addr.getText();
            String mClass = txtMAdd_Class.getText();
            String mRno = txtMAdd_Rno.getText();
            Calendar cd = Calendar.getInstance();	// Todays' Date like: "Wed Jun 12 10:38:59 PDT 2019"
            String day_mon_date_year = getDate_DyDtMnYr(cd);	// Returns like : "Jan 29,2019";
            String dbIns = getDbInsertableDate(day_mon_date_year);
            int selInd = comboMAdd.getSelectedIndex();
            String[] comboItems = {"Select type", "Student", "Teacher"};

            Connection con = getDbConnObj();
            Statement st = null;
            PreparedStatement pst = null;
            ResultSet rs = null;

            if (con == null) 
                throw new Exception("OOPs... Connection Error, Retry!");
            

            if (selInd == 0) // "Member Type Not Selected"
                throw new Exception("OOPs... Some fields Not Selected !");            

            if (mName == null || mName.length() == 0
                    || mPh1 == null || mPh1.length() == 0
                    || mAddr == null || mAddr.length() == 0) 
                throw new Exception("OOPs... Some fields are Empty !");
            

            if (!mName.matches("^[a-zA-Z ]{3,25}+$")) 
                throw new Exception("OOPs...Invalid Member Name,Must have 3-25 Alphabets !");
            
            if (!mPh1.matches("^[\\d]{10}+$")) 
                throw new Exception("OOPs...Invalid Phone Number 1, Should have 10 Digits!");
            
            if (mPh2 != null && mPh2.length() > 0) 
                if (! mPh2.matches("^[\\d]{10}+$")) 
                    throw new Exception("OOPs...Invalid Phone Number 2, Should have 10 Digits!");
                
            
            if (! mAddr.matches("^[-\\.\\w, ]{5,40}+$")) 
                throw new Exception("OOPs,Invalid Address,Len. should in 5-40 letters & [,-.]");
            

            int rno = 0;
            String classRnoSql = "'" + mClass + "', " + mRno;

            if (comboMAdd.getSelectedIndex() == 1) {// If Student Selected...Validate Class and Rno,

                if (!mClass.matches("^[a-zA-Z0-9 ]{1,10}+$")) 
                    throw new Exception("OOPs...Invalid Data in Class !");
                
                if (!mRno.matches("^[\\d]{1,}+$") || mRno.equals("0")) 
                    throw new Exception("OOPs...Invalid Roll Number given, Only Digits Allowed !");
                
                rno = Integer.parseInt(mRno);
                classRnoSql = "'" + mClass + "', " + mRno + " );";
            } else   // Faculty / Staff is going to be member of Library ...
                classRnoSql = "null,0 );";
            

            if (chkMAdd_iss.isSelected()) 
                issueBkAfterRegister = true;
            

            st = con.createStatement();
            // p("One");
            rs = st.executeQuery("Select count(*) as TotalMembers from mems");
            // p("Two");
            rs.next();
            int totalMembers = rs.getInt("TotalMembers");
            // p("Three");
            int mId = 1001 + totalMembers;
            String sql = "";/*This will hold like : " INSERT INTO mems (m_ID, mName, mPh1, mPh2, mAddr, mType, mJoinFee, mProtectFee, doj) " +
													" VALUES( "+mId+", '"+mName+"', '"+mPh1+"', '"+mPh2+"', '"+mAddr+"', '"
													+ comboItems[selInd].charAt(0)+"', 100.00 "+", 500.00, Date(sysdate()) );";				*/
            
            //mPh1 + "', '" + mPh2 + "', '" + mAddr
            //       "', '" + mPh2 + "', '"
            String ph2Handler = "";
            if(mPh2 == null || mPh2.length() == 0 )
                ph2Handler = "', null , '";
            else 
                ph2Handler = "', '"+ mPh2 +"' , '";
            
                sql = " INSERT INTO mems (m_ID, mName, mPh1, mPh2, mAddr, mType, mJoinFee, mProtectFee, doj, doPFee,Cls,rno) "
                    + " VALUES( " + mId + ", '" + mName + "', '" + mPh1 + ph2Handler + mAddr + "', '"
                    + comboItems[selInd].charAt(0) + "', 100.00 " + ", 500.00, Date(sysdate()),Date(sysdate()), " + classRnoSql;

            // p("\nQuery to Add Member : sql =>\n" + sql);
            // p(" \nmId =>" + mId + "<=\n mName =>" + mName + "<=\n mPh1 =>" + mPh1 + "<=\n mAddr=>" + mAddr + "<=\n" + "comboItems[selInd].charAt(0)=>" + comboItems[selInd].charAt(0) + "\n classRnoSql =>" + classRnoSql + "<=");
            st = null;
            st = con.createStatement();
            // p("Four");
            // p("mem add query : " + sql);
            int aff = st.executeUpdate(sql);
            // p("Five");
            if (aff == 0)
                throw new Exception("OOPs... Something went wrong, No Record Saved !");
			
            txtMAdd_Name.setText("");
            txtMAdd_Ph1.setText("");
            txtMAdd_Ph2.setText("");
            txtMAdd_Addr.setText("");

            lblMAddErr.setForeground(new Color(20, 140, 20));
            lblMAddErr.setText("Great... '" + mName + "' is a Member Now, Member Id = '" + mId + "'");

            if (issueBkAfterRegister) {
                showIssPanel(mName, mId, comboItems[selInd].charAt(0));
            }
        } catch (SQLException e) {
            // p(e.getMessage());
            try {
                throw new Exception("OOPs...Something went wrong,Record could not Saved !");
            } catch (Exception ex) {
                showMsgOnLbl(ex.getMessage(), lblMAddErr);
            }
        } catch (Exception e) {
            showMsgOnLbl(e.getMessage(), lblMAddErr);
        }
    }

    private void btnMAdd_resetActionPerformed(java.awt.event.ActionEvent evt) {	//  Method to Reset all the fields of Add Member ...
        comboMAdd.setSelectedIndex(0);
        txtMAdd_Name.setText("");
        txtMAdd_Ph1.setText("");
        txtMAdd_Ph2.setText("");
        txtMAdd_Addr.setText("");
        chkMAdd_iss.setSelected(false);
        lblMAddErr.setText("");

    }
    private void btnBkShow_Go1ActionPerformed(java.awt.event.ActionEvent evt) { //  This method will Check for Book and Shows Panel 'BookIssuePanel' Only if that Book is of Library...
	
        lblBkI_B_err.setVisible(false);
        lblBkI_B_err.setForeground(new Color(255, 0, 0));
        try {
            if (txtBkI_B_data.getText() == null || txtBkI_B_data.getText().equals("")) {
                throw new Exception("OOPs...Some Fields are Empty !");
            } else if (comboBkI_B.getSelectedIndex() == 0) {
                throw new Exception("OOPs...Search Condition is not Selected !");
            } else {

                // p("pnl_B 'next' clicked ,\n\t comboBkI_B.getSelectedIndex() = " + comboBkI_B.getSelectedIndex());
				// This method -.- setBookIssue_C will Fire the Query on the Basis of SelectedIndex of ComboBox & Set FetchedData to SubPnl_C...
                int ret = setBookIssue_C(comboBkI_B.getSelectedIndex());

                if (ret == -1)     			  // -1 Refers -     // OOPs... Connection Error
                    throw new Exception("OOPs... Connection Error, Retry Later !");
                else if (ret == 0)  		  //  0 Refers -     // OOPs... Data could not Fetched Properly , Retry !
                    throw new Exception("OOPs...Data could not Fetched Properly, Retry (Check Search Condition) !");
                else if (ret == -2)		  	  // -2 Refers- OOPs, No such "Select Condition, Id, Name, Type, Author" Found !
                    throw new Exception("OOPs... No such Book's Data Found, (Check Search Condition) !");
                else if (ret == -3) {   	  // -3 Refers- OOPs,This book is Unavailable, Visit on 
                    Connection c = getDbConnObj();
                    if (c == null) {
                        throw new Exception("OOPs... Connection Error");      // OOPs... Connection Error
                    }
                    Statement s = c.createStatement();
                    String q = "Select (select date_format( m_propDt ,'%b %d,%Y')) LastDate from bktrans where b_acc_id = " + txtBkI_B_data.getText() + " order by m_propDt limit 1;";
                    ResultSet r = s.executeQuery(q);
                    if (r == null || r.next() == false) {
                        throw new Exception("OOPs... No Books Available with this Book Id");      // OOPs... Connection Error
                    }						  // p("--> Reached : No Books Available for this Book Id\nQuery ->\n"+q);
                    throw new Exception("OOPs... No Books Available with this Book Id! [ Visit On " + r.getString("LastDate") + " ]");
                } else if (ret == 1) {  	  //  1 Refers - EveryThing is Done, Display Next Panel
                    pnlBkI_A.setVisible(false);
                    pnlBkI_D.setVisible(false);
                    pnlBkI_B.setVisible(false);
                    pnlBkI_C.setVisible(true);
                } else {
                    throw new Exception("OOPs...Something Went Wrong, Retry !");
                }
            }
        } catch (Exception e) {
            lblBkI_B_err.setVisible(true);
            showMsgOnLbl(e.getMessage(), lblBkI_B_err);
        }
    }

    private void btnBkD_back3ActionPerformed(java.awt.event.ActionEvent evt) { 	//  Method To Print Logo When Book Delete SubPanel D's BtnBack is Clicked	
        showOnlyPanel("pnlLogo");
    }
    private void pnlBkI_B_chgMemActionPerformed(java.awt.event.ActionEvent evt) {// Method to alter the Panel...

        lblBkI_A_Data.setText(txtBkI_B_mId.getText().substring(4));
        lblBkI_A_err.setText("");
        pnlBkI_C.setVisible(false);
        pnlBkI_D.setVisible(false);
        pnlBkI_B.setVisible(false);
        pnlBkI_A.setVisible(true);
        btnBkI_A_show.setVisible(false);
        lblBkI_A_err.setForeground(new Color(20, 140, 20));

    }

    private void btnBkD_back4ActionPerformed(java.awt.event.ActionEvent evt){	 // Method to show Logo...
        showOnlyPanel("pnlLogo");
    }

	
    private void pnlBkI_A_sub1ActionPerformed(java.awt.event.ActionEvent evt) {  // Method to check and Display which Member has issued which Book(s)['Books' is for Faculties only ]...
        try {
            lblBkI_A_err.setForeground(new Color(210, 10, 10));
            Connection con = getDbConnObj();
            if (con == null)
                throw new Exception("OOPs... Connection Error, Check & Retry !");
            
            Statement st = null;
            ResultSet rs = null;
            String mId = lblBkI_A_Data.getText();

// Checking if Input a Valid Member's Id or Not ...
            if (mId == null || mId.length() == 0) 
                throw new Exception("OOPs...Member Id is not Entered !");            

            if (!mId.matches("^[\\d]{4,}+$")) 
                throw new Exception("OOPs...Invalid Member Id is Entered !");
            

// This Query will Returns AllDetails(Fields) of This Member IF the Given M_id exists in All_Member_Table( mems )
            int memId = Integer.parseInt(mId);
            String sql = "Select * from mems where m_Id = " + memId;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs == null || rs.next() == false) 
                throw new Exception("OOPs...This Member does not Exists, Retry!");
            
            // p("Pnl A : 1 Member "+mId+" Exists,");
            // Checking Member Status ...(Active / Inactive ) :
            if (rs.getString("mStatus").equalsIgnoreCase("I")) //Inactive
                throw new Exception("OOPs... Member's Account is Currently Disabled !");
//                p("--In Issue Pnl A : Submitted :-> pnlBkI_A_sub1ActionPerformed(...) called :\n\t OOPs... Member's Account is Currently Disabled ");
            
            // p("Pnl A : 2 Active Member,");
            sql = "Select B.m_id M_Id, C.mName Member, C.mType TypeOfMember, B.b_acc_id BookId, A.b_Name Book,  "
                    + " date_format(B.m_issDt,'%b %d,%Y') IssuedOn, B.m_propDt LastDate "
                    + " from tbl_book_info A, bktrans B, mems C where B.m_id = " + memId + " and B.m_actRetDt is null "
                    + " and B.m_id = C.m_id and B.b_acc_id = A.b_acc_id order by B.m_id desc;";

            // p(sql);     //will Print : Select B.m_id M_Id, C.mName Member, C.mType TypeOfMember, B.b_acc_id BookId, A.b_Name Book,  date_format(B.m_issDt,'%b %d,%Y') IssuedOn, B.m_propDt LastDate from tbl_book_info A, bktrans B, mems C where B.m_id = 1002 and B.m_actRetDt is null and B.m_id = C.m_id and B.b_acc_id = A.b_acc_id order by B.m_id desc;
/*
This Query ^ Returns All Rows with these fields of The Member( 'S' / 'T' ) ---> If He had Not Returned any Book...
                                                                           ---> Else Empty set
 
+------+--------+--------------+--------+-------------+------------+------------+
| M_Id | Member | TypeOfMember | BookId | Book        | IssuedOn   | LastDate   |
+------+--------+--------------+--------+-------------+------------+------------+
| 1002 | Shubhu | T            |  10003 | VB.net book | Jun 11,2019| 2019-07-12 |
| 1002 | Shubhu | T            |  10004 | DBMS        | Mar 21,2019| 2019-03-24 |
+------+--------+--------------+--------+-------------+------------+------------+
                                        OR
+------+--------+--------------+--------+-------------+------------+------------+
| M_Id | Member | TypeOfMember | BookId | Book        | IssuedOn   | LastDate   |
+------+--------+--------------+--------+-------------+------------+------------+
| 1004 | Lalita | S            |  10001 | Java book   | 2019-04-21 | 2019-05-22 |
+------+--------+--------------+--------+-------------+------------+------------+             */ 
            rs = null;
            rs = st.executeQuery(sql);

            if (rs == null) // When Query Not Executed Properly
                throw new Exception("OOPs... Could not Found anything, Retry!");

            if (rs.next() == false) {       // When Member Came to Issuing Book For 1st Time / Returned Each Bk : Valid
                sql = "Select m_Id,mName Member,mType TypeOfMember from mems where m_id = " + memId;
                rs = null;
                rs = st.executeQuery(sql);
                rs.next();
                // p("issueBook(rs) 1st timer or Valid member");

                issueBook(rs);               // When Member Came to Issuing Book For 1st Time / Returned Each Bk : Valid
                pnlBkI_B.setVisible(true);
                pnlBkI_C.setVisible(false);
                pnlBkI_D.setVisible(false);
                pnlBkI_A.setVisible(false);
                lblBkI_B_err.setForeground(new Color(210, 10, 10));
                lblBkI_B_err.setVisible(false);
                throw new Exception("");    // Sent this new Users Details to SubPnl B , No need to go for Below code Execution
            }
//  Else This Member had Already Taken A Book, But not Returned,( Now Check Type : is He 'S'tudent  or 'T'eacher)
//      If('S'tudent -> Max. Num. of Not Returned Book = 0), // 
//      If('T'eacher -> Max. Num. of Not Returned Book = 2)
            int nBooksNotRet = 0;
            String rsMid = "";
            String rsMember = "";
            String rsTypeOfMember = "";
            String rsBookId = "";
            String rsBook = "";
            String rsIssuedOn = "";
            String rsLastDate = "";
            do {
                // p("for "+nBooksNotRet+" -> 0");
                rsMid = "" + rs.getInt("M_Id");
                // p("for "+nBooksNotRet+" -> 0.1");
                rsMember = rs.getString("Member");
                // p("for "+nBooksNotRet+" -> 0.2");
                rsTypeOfMember = "" + rs.getString("TypeOfMember");
                // p("for "+nBooksNotRet+" -> 0.3");
                rsBookId = "" + rs.getInt("BookId");
                // p("for "+nBooksNotRet+" -> 0.4");
                rsBook = rs.getString("Book");
                // p("for "+nBooksNotRet+" -> 0.5");
                rsIssuedOn = rs.getString("IssuedOn");
                // p("for "+nBooksNotRet+" -> 0.6");
                rsLastDate = rs.getString("LastDate");
                // p("for "+nBooksNotRet+" -> 0.7");
                nBooksNotRet++;

                // p("Took Book- Row "+nBooksNotRet+" Result =: "+rsMid+" ," +rsMember+" ,"  +rsTypeOfMember+" ," + rsBookId+" ," + rsBook+" ," + rsIssuedOn+" ," + rsLastDate+" ," );                
            } while (rs.next());
//  Note : rs'Cursor Reached After_Last Record

            // p("1");
            if (rsTypeOfMember.equalsIgnoreCase("S")) {
                String msg = "OOPs! " + rsMember + "[" + rsMid + "] took " + "(1) [" + rsBookId + "] " + rsBook + " on " + rsIssuedOn;
                // p("1.1");
                showBtnOfIssue_A(btnBkI_A_show, rs);     // This Btn Help to Show Details which Book(s) Not Return
                throw new Exception(msg);
            } else if (rsTypeOfMember.equalsIgnoreCase("T") && nBooksNotRet < 2) {
                String msg = "Warn! " + rsMember + "[" + rsMid + "] took " + "1) [" + rsBookId + "] " + rsBook + " on " + rsIssuedOn;
                showBtnOfIssue_A(btnBkI_A_show, rs);     // This Btn Help to Show Details which Book(s) Not Returned by the Teacher
                // p("1.2"); 

// When Member Teacher Came to Issue Book For him (might took less than Max.Limit_2 ) :Valid
                issueBook(rs);

                pnlBkI_C.setVisible(false);
                pnlBkI_D.setVisible(false);
                pnlBkI_A.setVisible(false);
                pnlBkI_B.setVisible(true);
                lblBkI_B_err.setForeground(new Color(20, 140, 20));
                lblBkI_B_err.setVisible(true);
                lblBkI_B_err.setText(msg);
            } else {
// When Member Teacher Came to Issue Book For him Already got 2 Books from Library    :Invalid
                String msg = "OOPs! " + rsMember + "[" + rsMid + "] took " + nBooksNotRet + " Books,1) [" + rsBookId + "] " + rsBook + "' on " + rsIssuedOn;
                showBtnOfIssue_A(btnBkI_A_show, rs);     // This Btn Help to Show Details which Book(s) Not Return, Currently only print output on Editor
                // p("1.3");
                throw new Exception(msg);
            }
        } catch (Exception e) {
            // p("2");
            lblBkI_A_err.setVisible(true);
            showMsgOnLbl(e.getMessage(), lblBkI_A_err);
        }
    }//GEN-LAST:event_pnlBkI_A_sub1ActionPerformed

    private void pnlBkI_B_chgMem1ActionPerformed(java.awt.event.ActionEvent evt) {// Method to Display Book Issue SubPanel 'B'
        pnlBkI_A.setVisible(false);
        pnlBkI_C.setVisible(false);
        pnlBkI_D.setVisible(false);
        pnlBkI_B.setVisible(true);
        lblBkI_B_err.setVisible(false);
    }

	private void pnlBkI_B_chgMem2ActionPerformed(java.awt.event.ActionEvent evt) {// Method to Display Book Issue SubPanel 'C'
        pnlBkI_D.setVisible(false);
        pnlBkI_A.setVisible(false);
        pnlBkI_B.setVisible(false);
        pnlBkI_C.setVisible(true);
    }
	
    private void btnBkShow_Go2ActionPerformed(java.awt.event.ActionEvent evt) {	  // Method to Set Fields and Display Book_Issue SubPanel 'D'
	//    Declarations: public String getDate_DyDtMnYr( Calendar cd )
	//                  public String getDbInsertableDate( String day_mon_date_year )
	//                  public Calendar getPossible_DateOfRet( Calendar cd )
        String dateOfIssue, dateOfReturn;
        Calendar cd = Calendar.getInstance();
        dateOfIssue = getDate_DyDtMnYr(cd).substring(4);
        cd.add(Calendar.DATE, 31);                                       // Adding 31 days to Current Date
        cd = getPossible_DateOfRet(cd);                               // This Method Makes sure that There must be no "Sunday" on Return Date
        dateOfReturn = getDate_DyDtMnYr(cd).substring(4);

        String bDoi = lblBk_I_C_mDoj.getText();
        String mNm = lblBk_I_C_mName.getText();
        String mId = lblBk_I_C_mId.getText();

        String bId = lblBk_I_C_bId.getText();
        String bNm = lblBk_I_C_bName.getText();
        String bAuth = lblBk_I_C_bAuth.getText();
        String bType = lblBk_I_C_bType.getText();
        String bAvb = lblBk_I_C_bAvb.getText();

		// Setting IssuePanel_C Labels' Data to IssuePanel_D_Labels
        lblBk_I_D_mId.setText(mId);
        lblBk_I_D_mNm.setText(mNm);
        lblBk_I_D_mAuth.setText(bAuth);
        lblBk_I_D_bId.setText(bId);
        lblBk_I_D_bNm.setText(bNm);
        lblBk_I_D_bType.setText(bType);

        lblBk_I_D_bNm2.setText(bNm);
        lblBk_I_D_mNm2.setText(mNm);
        lblBk_I_D_bIssDt.setText(dateOfIssue);
        lblBk_I_D_bRetDt.setText(dateOfReturn);
        // set Issue Date and Return Date of IssuePanel_D

        pnlBkI_B.setVisible(false);
        pnlBkI_C.setVisible(false);
        pnlBkI_A.setVisible(false);
        pnlBkI_D.setVisible(true);
        lblBkI_D_err.setVisible(false);
    }

	private void btnBkShow_Go3ActionPerformed(java.awt.event.ActionEvent evt) {	  // Method to Store Book Issue Details...
        /*
			When IssuePanel_D FinalSubmit --> What will Happen ...?
			
			Tables Affected  :  1) tbl_books
							    2) bktrans
			Steps:				
				1) Select any 1 ACCNO from tbl_books where tbl_books.accid = GIVEN_ACCID  and  Status = 'A' 				
				2) Update tbl_books set Status = 'I' which has tbl_books.accid = GIVEN and tbl_books.accno = FETCHED PREVIOUSLY in step 1
				3) bktrans me Insert karo pnl_D_Labels ki 
				3) Insert into bktrans ...
					Attributes of Table 'bktrans': 
					--------------------------------
						m_id , b_acc_id , accno , m_issDt  
						,  m_propDt  ,  m_actRetDt , m_fine , m_delayCause , m_nPropDt 
					Labels of Issue_SubPanel_D  : 
					--------------------------------
						lblBk_I_D_mId , lblBk_I_D_bId , accno = fetched Prev , dbInsertableDate( lblBk_I_D_bIssDt ) 
						,  dbInsertableDate( lblBk_I_D_bRetDt ) , NULL , NULL , NULL , NULL
			Solution:
				1) -.-
					Select accno from tbl_books where accid = GIVEN_Accid and status = 'A' limit 1;
				2) -.-
					Update tbl_books set status = 'I' where accid = 10001 limit 1;
				3) -.-
					insert into bktrans ( m_id, b_acc_id, accno, m_issDt, m_propDt ) 
							value(1003,10001,101, '2019-06-23' ,'2019-07-25' );
         */
        try {
            p("1");
            Connection con = getDbConnObj();
            if (con == null) {
                throw new Exception("OOPs... Connection Error, Check and Retry !");
            }
            Statement st = con.createStatement();
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            int issueAccno, issueAccid = Integer.parseInt(lblBk_I_D_bId.getText());

            String strMid = lblBk_I_D_mId.getText();                           // "[S] 1001"

            int mId = Integer.parseInt(strMid.substring(4));                   // "1001"
            Calendar cd = Calendar.getInstance();
            p("2 - cd = Calendar.getInstance() : " + cd.getTime());
            cd.add(Calendar.DATE, 31);
            cd = getPossible_DateOfRet(cd);                                  // "No Sunday on Returning Day.
            p("3 - cd = getPossible_DateOfRet( cd ) : " + cd.getTime());
            String dyddmmyy = getDate_DyDtMnYr(cd);                          // "Last Date 'Tue Jan 23,1999' "
            p("4 - String dyddmmyy = getDate_DyDtMnYr( cd ) = " + dyddmmyy);
            dyddmmyy = getDbInsertableDate(dyddmmyy);                        // "Last Date '1999-01-23' "
            p("5 - dyddmmyy = getDbInsertableDate( dyddmmyy ) = " + dyddmmyy);
            String lastDate = lblBk_I_D_bRetDt.getText();

            String sql = "Select accno from tbl_books where accid = " + issueAccid + " and status = 'A' limit 1";
            rs = st.executeQuery(sql);
            p("---> Step 1 query :\n" + sql);
            if (rs == null || rs.next() == false) {
                throw new Exception("OOPs... Some Data is Currpted( Err Id : 9001 )!");
            }
            issueAccno = rs.getInt("accno");        //  Step 1 Accomplished ...            
            rs = null;

//            sql = "Update tbl_books set status = 'I' where accid = "+ issueAccid + " and accno = "+ issueAccno;            
            sql = "Update tbl_books set status = 'I' where accid = ? and accno = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, issueAccid);
            pstmt.setInt(2, issueAccno);

            if (pstmt.executeUpdate() == 1) {
                p("+++> Step 2 query :\n" + sql + "\n\t? 1->" + issueAccid + ", ?2 ->" + issueAccno);
            } else {
                throw new Exception("OOPs 2...Could not Save Data, Retry !");
            }
//            int aff = st.executeUpdate(sql);    // aff will have 1 if Update Query Executed Successfully

//            sql = "Insert into bktrans ( m_id, b_acc_id, accno, m_issDt, m_propDt ) " +
//                  "value("+ mId +","+ issueAccid +","+ issueAccno +
//                             ", date(sysdate()) ,'"+ dyddmmyy +"' );";          //  Insert into bktrans ( m_id, b_acc_id, accno, m_issDt, m_propDt ) value(1001,10003,102, date(sysdate()) ,'2019-21-22' );
            sql = "Insert into bktrans ( m_id, b_acc_id, accno, m_issDt, m_propDt ) "
                    + "value(?,?,?, date(sysdate()) ,? );";          //  Insert into bktrans ( m_id, b_acc_id, accno, m_issDt, m_propDt ) value(1001,10003,102, date(sysdate()) ,'2019-21-22' );
            pstmt = null;
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, mId);
            pstmt.setInt(2, issueAccid);
            pstmt.setInt(3, issueAccno);
            pstmt.setString(4, dyddmmyy);

            if (pstmt.executeUpdate() == 1) {
                pnlBkI_D.setVisible(false);
                pnlBkI_B.setVisible(false);
                pnlBkI_C.setVisible(false);
                pnlBkI_A.setVisible(true);
                lblBkI_A_err.setVisible(true);
                lblBkI_A_err.setForeground(new Color(20, 140, 20));
                p(">>>> All Done ...\nBktrans Aff.Rows== ");
                lblBkI_A_err.setText("Great! Book[ " + issueAccid + " ] issued to Mem[ " + mId + " ], Last Date: ["
                        + dyddmmyy + "] ");
                // Reset Issue_SubPanel_B fields...                
                txtBkI_B_data.setText("");
                comboBkI_B.setSelectedIndex(0);
                p("***> Step 3 query :\n" + sql + " ?s = " + mId + "_" + issueAccid + "_" + issueAccno + "_" + dyddmmyy);
            } else {
                throw new Exception("OOPs 3...Could not Save Data, Retry !");
            }
//            aff = st.executeUpdate(sql);    // aff will have 1 if Update Query Executed Successfully
//            p("\nbktrans Aff.Rows== "+aff);

        } catch (Exception e) {
            lblBkI_D_err.setVisible(true);
            lblBkI_D_err.setText(e.getMessage());
        }
    }

    private void btnBkI_A_showActionPerformed(java.awt.event.ActionEvent evt) {	  // Method to get Width and Height...
        p("pnlBkIssue bounds =: x=" + pnlBkIssue.getX() + ", y=" + pnlBkIssue.getY() + ", w=" + pnlBkIssue.getWidth() + ", h=" + pnlBkIssue.getHeight());
    }//btnBkI_A_showActionPerformed

		
    private void comboBkI_BActionPerformed(java.awt.event.ActionEvent evt) {	  // Method to set Tool Tip for Search Box...

        int selInd = comboBkI_B.getSelectedIndex();
        comboBkI_B.setForeground(Color.red);
        switch (selInd) {
            // Select Condition , Id , Name , Type  , Author 
            //          0       ,  1 ,   2  ,   3   ,   4            
            case 0:
                txtBkI_B_data.setToolTipText("Select The Search Condition ...");
                break;
            case 1:
                comboBkI_B.setForeground(Color.green);
                txtBkI_B_data.setToolTipText("Enter the Book Id");
                break;
            case 2:
                comboBkI_B.setForeground(Color.green);
                txtBkI_B_data.setToolTipText("Enter First Few Characters of the Name of the Book");
                break;
            case 3:
                comboBkI_B.setForeground(Color.green);
                txtBkI_B_data.setToolTipText("Enter First Few Characters of the Type of the Book");
                break;
            case 4:
                comboBkI_B.setForeground(Color.green);
                txtBkI_B_data.setToolTipText("Enter First Few Characters of the Author of the Book");
                break;
        }
    }

    private void listBkShow1ValueChanged(javax.swing.event.ListSelectionEvent evt) {// Method to Update the Labels of IssuePanel's SubPanel_C According to --> Element of List is Selected
        setComps_Issue_C_OnListChange();
    }

    private void btnBkD_back7ActionPerformed(java.awt.event.ActionEvent evt) {		// Method to show Logo Panel...
        showOnlyPanel("pnlLogo");
    }

    private void pnlBkI_A_sub2ActionPerformed(java.awt.event.ActionEvent evt) {		// Method to fetch details of a member from Table bktrans...
	
        try {
            lblBkR_A_err.setText("");
            lblBkR_A_err.setForeground(new Color(255, 0, 0));
            Connection con = getDbConnObj();
            if (con == null) {
                throw new Exception("OOPs... Connection Error, Check & Retry !");
            }
            Statement st = null;
            ResultSet rs = null;
            String mId = lblBkR_A_Data.getText();

		// Checking if Input a Valid Member's Id or Not ...
            if (mId == null || mId.length() == 0) {
                throw new Exception("OOPs...Member Id is not Entered !");
            }

            if (!mId.matches("^[\\d]{4,}+$")) {
                throw new Exception("OOPs...Invalid Member Id is Entered !");
            }

		// This Query will Returns AllDetails(Fields) of This Member IF the Given M_id exists in All_Member_Table( mems )
            int memId = Integer.parseInt(mId);

            String sql= "Select b.m_Id m_Id, m.mName Member, m.mType MemberType , b.b_acc_id accid, b.accno accno, "
                            + "c.b_name Book,c.b_auth1 Author, date_format(b.m_issDt,'%b %d,%Y') issuedOn, "
                            + "date_format(b.m_propDt, '%b %d,%Y') lastDate, date_format(Date(sysdate()),'%b %d,%Y') Today,"
                            + "(Case when true then ( datediff( b.m_propDt , sysdate() ) ) else 0 end ) as daysDelayed , b.t_id "
                        +"From bktrans b, mems m ,tbl_book_info c "
                        +"Where b.m_Id = " + memId + " and b.m_actRetDt is null and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id ;";

            // p("\nReturn Book SubPnl_B_sql ====> \n" + sql + "\n");                // Will Print query = Select b.m_Id m_Id, m.mName Member, m.mType MemberType , b.b_acc_id accid, b.accno accno, c.b_name Book,c.b_auth1 Author, date_format(b.m_issDt,'%b %d,%Y') issuedOn, date_format(b.m_propDt, '%b %d,%Y') lastDate, date_format(Date(sysdate()),'%b %d,%Y') Today,(Case when true then ( datediff( b.m_propDt , sysdate() ) ) else 0 end ) as daysDelayed ,b.t_id from bktrans b, mems m ,tbl_book_info c where b.m_Id = 1001 and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null;		
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs == null || rs.next() == false) {
		//  No Records found in Bktrans table for this Member Id ...
                rs = null;
                sql = "Select * from mems where m_id = " + memId;
		/*    +------+---------+------------+------+----------------+-------+----------+-------------+---------+------------+
			  | m_Id | mName   | mPh1       | mPh2 | mAddr          | mType | mJoinFee | mProtectFee | mStatus | doj        |
			  | 1001 | Shubham | 8601725056 |      | Ramjanki nagar | S     |   100.00 |      500.00 | A       | 2019-06-29 |
			  +------+---------+------------+------+----------------+-------+----------+-------------+---------+------------+
						 */
                rs = st.executeQuery(sql);
                if (rs == null || rs.next() == false) //  This member Doesn't Exists...
                    throw new Exception("OOPs... This Member Id does not Exists !");
                
		//  Else Member Exists but didn't issued Any book to him...
                throw new Exception("OOPs... No Books issued to This Member " + rs.getInt("m_Id") + "!");
            }
            /*  Output of the Query : 
			-- ---------- When member is Late : 
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
			| m_Id | Member | MemberType | accid | accno | Book     | Author | issuedOn    | lastDate    | Today       | daysDelayed | t_id |
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
			| 1001 | Lala   | S          | 10003 |   101 | Cpp 1.17 | lalaji | Jun 21,2019 | Jul 22,2019 | Aug 02,2019 |         -11 |   16 |
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+

			-- ---------- When member have to Return Today :
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
			| m_Id | Member | MemberType | accid | accno | Book     | Author | issuedOn    | lastDate    | Today       | daysDelayed | t_id |
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
			| 1002 | Shubhu | T          | 10002 |   101 | Cpp Book | Kallo  | Jun 21,2019 | Jul 22,2019 | Jul 22,2019 |           0 |   16 |
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+

			-- ---------- When member has n Days to Return :
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
			| m_Id | Member | MemberType | accid | accno | Book     | Author | issuedOn    | lastDate    | Today       | daysDelayed | t_id |
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
			| 1002 | Shubhu | T          | 10002 |   101 | Cpp Book | Kallo  | Jun 21,2019 | Jul 22,2019 | Jul 15,2019 |           7 |  16  |
			+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
             */

            listBkRet = null;
            listBkRet = new java.util.ArrayList<>();
            String listValue;
            do{
                int delayed = rs.getInt("daysDelayed");
                int t_id = rs.getInt("t_id");
                String mName = rs.getString("Member"),
                        mType = rs.getString("MemberType"),
                        accId = "" + rs.getInt("accid"),
                        accNo = "" + rs.getInt("accno"),
                        bkName = rs.getString("Book"),
                        bkAuth = rs.getString("Author"),
                        bkIssDt = rs.getString("issuedOn"),
                        bkLastDt = rs.getString("lastDate"),
                        today = rs.getString("Today");
                String sep = "^^^"; // Data Separator to Avoid 
                //  1) Again And Again Firing Query for Setting Data on Different SubPanels of Return Panel ,
                //  2) Processing Time Consumption...
                // 'M_Id | Member | MemberType | accid | accno | Book | Author | issuedOn | lastDate | Today | daysDelayed | t_id stored with DataSep

                listValue = memId + sep + mName + sep + mType + sep + accId + sep + accNo + sep + bkName + sep + bkAuth
                        + sep + bkIssDt + sep + bkLastDt + sep + today + sep + delayed + sep + t_id;
				// listValue = "\n1002^^^Shubhu^^^T^^^10002^^^101^^^Cpp Book^^^Kallo^^^2019-06-21^^^2019-07-22^^^2019-08-01^^^10^^^17";
                listBkRet.add(listValue);
                // p("\n---> Details of Books not Returned : \n\t memId + sep + mName + sep + mType + sep + accId + sep + accNo +sep + bkName + sep + bkAuth + sep + bkIssDt + sep + bkLastDt + sep + today + sep + delayed\n" + listValue);
				//                p("\n\t Global listValue(n) => "+listValue);
            } while (rs.next());

            try {
                listBkR_B.setModel(
                        new javax.swing.AbstractListModel<String>() {
			// Method getIssRetBooksRecords() will Take a "ArrayList<String> Object" 
			// and Returns String[] Array having all the Elements of ArrayList<String> Object;

			// This method getRetBooksRecords() will return StrArr : which has String Objects that will display on List
                    String[] strings = getRetBooksRecords();

                    public int getSize() {
                        /*  p2("\t (-1) listBkR_B.setModel's getSize() exe..ing"); */ return strings.length;
                    }

                    public String getElementAt(int i) { //  p2("\n(-0) listBkR_B.setModel's getElementAt() exe..ing");p2("\tValue Stored in Str Arr : ");for(String s : strings){ p2("\t"+s); }
                        return strings[i];
                    }
                    //  public void p2(String msg){ System.out.println(msg); }
                }
                );
            } catch (Exception e) {
                // p("Nominal Exception - ... May be IllegalArgumentException occured ~4660 when Setting String to ReturnSubPnl_B_Listbox ,err = " + e.getMessage());
            }

            listBkR_B.setSelectedIndex(0);

            pnlBk_R_A.setVisible(false);
            pnlBk_R_B.setVisible(true);
            lblBkR_B_err.setText("");
        } catch (Exception e) {
            // p("\n??? Return Book Exception occured ...");
            lblBkR_A_err.setText(e.getMessage());
        }
    }
	
    private void pnlBkI_B_chgMem3ActionPerformed(java.awt.event.ActionEvent evt) {	// Method to Prepare Book Return SubPanel A...
        pnlBk_R_B.setVisible(false);
        pnlBk_R_A.setVisible(true);
        lblBkR_A_err.setForeground(new Color(255, 0, 0));
        lblBkR_A_Data.setText("");
        lblBkR_A_err.setText("");
    }

    private void pnlBkI_B_sub1ActionPerformed(java.awt.event.ActionEvent evt) {		// Method to Perform Action when Return Book_SubPnl_B_Submit Clicked ...
        
        String[] arrBkRet;
        int selInd = listBkR_B.getSelectedIndex();
        arrBkRet = (listBkRet.get(selInd)).split("([\\^\\^\\^]+)");
        // split("[^^^]+") = "1002   Shubhu   T   10002   101   Cpp Book   Kallo   Jun 21,2019   Jul 22,2019   Jul 29,2019  -7  ";
        //         temp     [   0       1     2     3      4        5        6          7             8              9      10  ];
        //                        p("----> Return Books : Next Clicked - 0)");

		//  When Selected item of List is going to Return with checking All Conditions, check conditions in ==> public void setBkRetListLabels(int selInd)
        if (pnlBkI_B_sub1.getText().equals("Return")) {
            try {
			//  p("if(pnlBkI_B_sub1.getText().equals(\"Submit\" == true");
                Connection con = getDbConnObj();
                if (con == null) {
                    throw new Exception("OOPs... Connection Error !");
                }
                Statement st = con.createStatement();
			//  String sql = "set autocommit = 0;savepoint insRetDt;Update Bktrans set m_actRetDt = Date(sysdate()) where m_id = "+ Integer.parseInt(arrBkRet[0]) +" and b_acc_id = "+ Integer.parseInt(arrBkRet[3]) +" and accno = "+ Integer.parseInt(arrBkRet[4]) +";";
			//  	Here 'savepoint abc;'   is NOT executeUpdate() type ...
                String sql = "Update Bktrans set m_actRetDt = Date(sysdate()) where m_id = " + Integer.parseInt(arrBkRet[0]) + " and b_acc_id = " + Integer.parseInt(arrBkRet[3]) + " and accno = " + Integer.parseInt(arrBkRet[4]) + ";";
                int aff = -2;
			//  p("\nReturn Books : Next Clicked - 1)\n "+sql +"\n\t ");
                aff = st.executeUpdate(sql);
			//  p("and Update Bktrans -->> aff0 = "+aff+"\n");
                if (!(aff > 0)) {
                    throw new Exception("OOPs... Could not Perform 'Return Book', Retry !");
                } else {
                    aff = -3;
                    sql = "UPDATE tbl_books set status = 'A' where accid = " + Integer.parseInt(arrBkRet[3]) + " and accno = " + Integer.parseInt(arrBkRet[4]) + " and status = 'I';";
				// p("\nReturn Books : Next Clicked - 2)\n "+sql +"\n\t");
                    st = con.createStatement();
                    aff = st.executeUpdate(sql);
				// p("and Update Bktrans==> aff1 = "+aff+"\n");
                    if (!(aff > 0)) {
                        throw new Exception("OOPs... Could not Perform 'Return Book', Retry !");
                    } else {
                        lblBkR_A_err.setForeground(new Color(20, 140, 20));
                        lblBkR_A_Data.setText("");
                        pnlBk_R_B.setVisible(false);
                        pnlBk_R_A.setVisible(true);
                        lblBkR_A_err.setText("Great! " + arrBkRet[1] + "[ " + arrBkRet[0] + " ] returned '" + arrBkRet[5] + "'.");
					// throw new Exception("Great, "+arrBkRet[1]+"[ "+ arrBkRet[0] +" ] returned ");
                    }
                }
            } catch (Exception e) {
                // p("??? Exception => " + e.getMessage());
                lblBkR_B_err.setVisible(true);
                showMsgOnLbl(e.getMessage(), lblBkR_B_err);
            }
        } else {
/*		  Else When Selected Item of List is going to Return book Late : check conditions in ==> public void setBkRetListLabels(int selInd)
		    Fine Panel ko Manage on ReturnPnl_SubPnl_C ...

						 listBkRet.get( 0 )= "1002^^^Shubhu^^^T^^^10002^^^101^^^Cpp Book^^^Kallo^^^Jun 21,2019^^^Jul 22,2019^^^2019-08-01^^^10";
						arr=split("[^^^]+")= "1002   Shubhu   T   10002   101   Cpp Book   Kallo   Jun 21,2019   Jul 22,2019   Jul 29,2019  -7  ";
								   temp     [   0       1     2     3      4        5        6          7             8              9      10  ];
					 
		   calling a method() to set pnlBkR_C and pnlBkR_C_subPnl2 's Labels		*/
		   
            setPnlB_R_C_1();
            lblRetBook.setVisible(false);
            pnlBk_R_B.setVisible(false);
            pnlBk_R_C.setVisible(true);
            lblBkR_C_err.setText("");
        }
    }

	
    private void btnBkD_back9ActionPerformed(java.awt.event.ActionEvent evt) {	    // Method for date / Back...
	
        Calendar c = Calendar.getInstance();
        // p("Before subtraction date :" + c.getTime());
        c.add(Calendar.DATE, -2);
        // p("After subtraction date  :" + c.getTime());

	}
    
	private void pnlBkI_B_chgMem4ActionPerformed(java.awt.event.ActionEvent evt) {	// Method for Book Return SubPanel B...
        pnlBk_R_C.setVisible(false);
        pnlBk_R_B.setVisible(true);
        lblBkR_B_err.setText("");
        lblRetBook.setVisible(true);;
    }

    private void btnBkShow_Go5ActionPerformed(java.awt.event.ActionEvent evt) {		// Method to handle Book Return Subpanel C whether charge fine or not...
        lblBkR_C_err.setText("");
        lblBkR_C_err.setForeground(new Color(255, 0, 0));
        try {
//  Checking , When BkRet_C is Submitted then Which SubPanel was Visible...and is it Set or Not
            if (pnlBkR_C_sub1.isVisible()) {
                if (btnRetBkRecv.getText().equals("Receive")) {
                    throw new Exception("OOPs...Fine Not Received, click on 'Receive'!");
                }
                returnBookFromSubPnl(1);
            } else {
                String changedDate = txtBkRet_C_2_nDays.getText();
                if (radioR_C_inc.isSelected() == false && radioR_C_dec.isSelected() == false) {
                    throw new Exception("OOPs...Select Increment / Decrement Option !");
                }

                if (txtBkRet_C_2_reason.getText().equals("Because of ") || txtBkRet_C_2_reason.getText().equals("")
                        || (txtBkRet_C_2_reason.getText().length() < 10)) {
                    throw new Exception("OOPs...Reason was not given Properly !");
                }
                if (changedDate.equals("0") || (!changedDate.matches("^[\\d]+$"))) {
                    throw new Exception("OOPs...Only 1-9 digits are Allowed in 'Date Modify' Field !");
                }
                returnBookFromSubPnl(2);
            }
        } catch (Exception e) {
            showMsgOnLbl(e.getMessage(), lblBkR_C_err);
        }
        /*
                                                Before Submitting for Return
mysql> select * from bktrans where m_id = 1007;select * from tbl_books where accid = 10003 and accno = 102;
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
|   30 | 1007 |    10003 |   102 | 2019-07-28 | 2019-08-28 | NULL       |   NULL | NULL         |      NULL |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+


+-------+-------+--------+
| accid | accno | status |
+-------+-------+--------+
| 10003 |   102 | I      |
+-------+-------+--------+
1 row in set (0.00 sec)
                                                After Submitting for Return
mysql> select * from bktrans where m_id = 1007;select * from tbl_books where accid = 10003 and accno = 102;
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
|   30 | 1007 |    10003 |   102 | 2019-07-28 | 2019-08-28 | 2019-08-30 |   4.00 | NULL         |      NULL |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
1 row in set (0.00 sec)

+-------+-------+--------+
| accid | accno | status |
+-------+-------+--------+
| 10003 |   102 | A      |
+-------+-------+--------+
1 row in set (0.00 sec)

                                                    Resetting / RollBacking
mysql> update bktrans set m_actRetDt=null,m_fine= null, m_delayCause = null, m_nPropDt = null where t_id = 30;

mysql> update tbl_books set status = 'I' where accid = 10003 and accno = 102;

         */
    }//  

    private void listBkR_BValueChanged(javax.swing.event.ListSelectionEvent evt) {	// Method to handle Selected Book info from List of Issued books to Return...
        int selInd = listBkR_B.getSelectedIndex();
        setBkRetListLabels(selInd);// 0 and 1 only
    }

    private void btnRetBkRecvActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to handle Toggle btn of Return book...
        btnRetBkRecv.setText("Received");
        btnRetBkRecv.setForeground(new Color(20, 180, 20));
    }//  

    private void comboBk_R_CActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to handle ComboBox of Return Books subpanel C...
        if (comboBk_R_C.isSelected()) { // Charge the Fine ...and Return
            pnlBkR_C_sub2.setVisible(false);
            pnlBkR_C_sub1.setVisible(true);
            setRet_C_SubPnl(2);
			//            pnlBkR_C_sub1.setBounds( 147,190,605,196 );
        } else {                          // Show Last Date Extending Panel...and Return
			//            pnlBkR_C_sub2.setBounds( 147,190,605,196 );
            pnlBkR_C_sub1.setVisible(false);
            pnlBkR_C_sub2.setVisible(true);
            setRet_C_SubPnl(1);
        }
    }
    private void checkRep_1ActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to handle Label and List of Overdue Issued Books...
        if (checkRep_1.isSelected()) {
            repSub1.setBackground(new Color(240, 240, 240));
            lblRepDt.setText("Date(dd-mm-yyyy)    --");
            txtRepDD.setVisible(true);
            txtRepMM.setVisible(true);
            txtRepYYYY.setVisible(true);

        } else {
            repSub1.setBackground(new Color(240, 241, 240));
            lblRepDt.setText("  ");
            txtRepDD.setVisible(false);
            txtRepMM.setVisible(false);
            txtRepYYYY.setVisible(false);
        }
    }//  

    private void checkRep_2ActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to handle Label and List of Overdue Issued Books on other Subpanel...
        if (checkRep_2.isSelected()) {
            repSub2.setBackground(new Color(240, 240, 240));
            lblRepDt2.setText("Date(dd-mm-yyyy)    --");
            txtRepDD2.setVisible(true);
            txtRepMM2.setVisible(true);
            txtRepYYYY2.setVisible(true);
        } else {
            repSub2.setBackground(new Color(240, 241, 240));
            lblRepDt2.setText("  ");
            txtRepDD2.setVisible(false);
            txtRepMM2.setVisible(false);
            txtRepYYYY2.setVisible(false);
        }
    }//  

	
    private void reportSubmitActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to handle Report Submittion as PDF Creation...
        
        String ret = "";
        int arrSelBox[] = null;
        arrSelBox = new int[]{0, 0, 0, 0};

        try {
		//  checking If 1st Checkbox selected : if Yes -> Its Date feilds are filled Properly or Not
            if (checkRep_1.isSelected()) {
                ret = validateReportInfo(1);    // Checks Rel.Date Details
                if (ret.equals("ok") == false) 
                    throw new Exception(ret);
                else
                    arrSelBox[0] = 1;
            }
		//  checking If 2st Checkbox selected : if Yes -> Its Date feilds are filled Properly or Not
            if (checkRep_2.isSelected()) {
                ret = "";
                ret = validateReportInfo(2);    // Checks Rel.Date Details
                if (ret.equals("ok") == false) 
                    throw new Exception(ret);
                else
                    arrSelBox[1] = 1;

		//  check_UpdateExpiryOfMem_ship() method Checks and Updates Membership Expiry Status from 'A'ctive to 'I'nactive ...
                check_UpdateExpiryOfMem_ship();
            }

            if (checkRep_3.isSelected()) {
                if (comboRep3.getSelectedIndex() == 0) 
                    throw new Exception("OOPs...Criteria, for 3rd Report query, is not Selected !");                
                else 
                    arrSelBox[2] = 1;
            }           
            if (checkRep_4.isSelected()) {
                if (comboRep4.getSelectedIndex() == 0) 
                    throw new Exception("OOPs...Criteria, for 4th Report query, is not Selected !");
                else
                    arrSelBox[3] = 1;
            }
		//  Till Now Date & ComboBox is Checked and Validated, Now which Queries we'll have to Fire ...

            String homeDir = System.getProperty("user.home");
            String pathSep = System.getProperty("file.separator");
            String folder = "LibraryReports";
            String filename = getFileName_DateTimeName();
            String pathTillFolder = homeDir + pathSep + folder;
            String pathTillFile = homeDir + pathSep + folder + pathSep + filename;

            File fp = new File(pathTillFolder);
            if (fp.mkdir()) {
                p("New Folder Created.");
            } else {
                p("Folder already exists.");
            }

		//  Till Now 'Directory' is Created where PDF : 'dc' will Reside ...
            Connection con = null;
            con = getDbConnObj();
            if (con == null)
                throw new Exception("OOPs... Connection error, Check and Retry !");

            String sql = "";
            Statement st = null;
            ResultSet rs = null;

		//            if(rs == null || rs.next() == false)
		//                throw new Exception("No rows Found");
		//  Creating PDF ...
            Document dc = new Document();
            Paragraph para = null;  // new Paragraph(msg);            
            PdfWriter.getInstance(dc, new FileOutputStream(pathTillFile));
            dc.open();

            String headNote = "Report - My Dream Library : " + getReportTime();
		//  Setting Header of Report :
            PdfPTable table = new PdfPTable(1);
            PdfPCell c1 = new PdfPCell(new Phrase(headNote));
            c1.setBackgroundColor(BaseColor.RED);
            c1.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
            c1.setPaddingBottom(20.0f);
            c1.setPaddingTop(20.0f);
            c1.setPaddingLeft(90.0f);
            c1.setPaddingRight(90.0f);
            table.addCell(c1);
            dc.add(table);
            dc.add(new Paragraph(" "));
		//  Setting Query Results In PDF...            
            for (int i = 0; i < 4; i++) {
                if (arrSelBox[i] == 1) {                    // Whichever ReportPanel's CheckBox is Selected...Go in Loop and check For all 4 Reports...
                    sql = getReportQueryFor(i);
                    st = con.createStatement();
                    rs = st.executeQuery(sql);
                    dc = createReport(rs, dc, i);           // Updating PDF or say itext.Document's dc
                }
            }
		//  Till Now All Report is in PDF...
            dc.close();
            p("\nPdf Document saved");
            p("\nPath till pdf Folder " + pathTillFolder);
        } catch (Exception e) {
			p("!!! Exception in reportSub.Act.Per...(), msg=>"+e.getMessage());
            showMsgOnLbl(e.getMessage(), reportErr);
        }
    }//  

    private void reportResetActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to Reset Report Components ...
        resetReportComps();
    }//  

    private void comboMAddActionPerformed(java.awt.event.ActionEvent evt) {			//  Method to handle Report...
        if (comboMAdd.getSelectedIndex() == 0 || comboMAdd.getSelectedIndex() == 2) {
            txtMAdd_Class.setEditable(false);
            txtMAdd_Class.setText("");
            txtMAdd_Rno.setEditable(false);
            txtMAdd_Rno.setText("");
        } else {      				// Student is Selected ...Take Input in Class and Rno Field...
            txtMAdd_Class.setEditable(true);
            txtMAdd_Rno.setEditable(true);
        }
    }//  

    private void btnMemAddActionPerformed(java.awt.event.ActionEvent evt) {			//  Method to Add Member...
        showOnlyPanel("pnlMAdd");
        lblMAddErr.setText("");
        lblMAddErr.setForeground(Color.red);
        Calendar cd = Calendar.getInstance();	// Todays' Date like: "Wed Jun 12 10:38:59 PDT 2019"
        String mon_date_year = getDate_DyDtMnYr(cd);	// Returns like : "Wed Jan 29,2019";
        txtMAdd_doj.setText(mon_date_year.substring(4));// from Month i.e. : "Jan...";
        comboMAdd.setSelectedIndex(0);
        chkMAdd_iss.setSelected(false);
        txtMAdd_Class.setText("");
        txtMAdd_Rno.setText("");
    }//  

    private void btnReportBackActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to handle Back Btn of Report Panel...
        showOnlyPanel("pnlLogo");
    }//  

    private void listBkDel_BValueChanged(javax.swing.event.ListSelectionEvent evt) {//  Method to handle Book Field value when List's selected item changes...
        setComps_DelBk_B_OnListChange();
    }//  

    private void btnBkD_back10ActionPerformed(java.awt.event.ActionEvent evt) {		//  Method to handle Back Btn...
        showOnlyPanel("pnlLogo");
    }//  

    private void pnlBkI_B_chgMem5ActionPerformed(java.awt.event.ActionEvent evt) {	//  Method to Display Delete_Sub_Panel...
        showOnlyPanel("pnlBkDel");
    }//  

    private void btnBkShow_Go4ActionPerformed(java.awt.event.ActionEvent evt) {		//  Method will called when 'Book Delete Panel B is Submitted...'
        setBkDel_C_Panel();             // IF All gose well THAN Set Labels and Show Panel 'pnlBkDelNow'...Book Delete Panel 3
        showOnlyPanel("pnlBkDelNow");
    }//  

    private void btnBkDel_D_SubmitActionPerformed(java.awt.event.ActionEvent evt) {	//  Method will invoked when 'Book Delete SubPanel D "pnlBkDel_D" is Submitted (/ 'Selected' is Clicked.)'...		
		//   till now Global Obj 'listbkval' can have more than One Records( for Teacher who lost a book and now selected One of Them)...      
        int selInd = listBkDel_D.getSelectedIndex();
        setFinalBookDelPanel_E(selInd);
        
    }
    private void btnBkDel_D_CancelActionPerformed(java.awt.event.ActionEvent evt) {	//  Method will Called when : Book Deletion Panel -  "pnlBkDel_D" 's  Btn 'Cancel' is Clicked...
        
        listBkRet = null;
        listBkRet = new java.util.ArrayList<>();
        showOnlyPanel("pnlLogo");
    }//  

    private void btnBkDel_D_BackActionPerformed(java.awt.event.ActionEvent evt) {	//  This method will Called when : Book Deletion Panel-  "pnlBkDel_D" 's  Btn 'Back' is Clicked...

        listBkRet = null;
        listBkRet = new java.util.ArrayList<>();
        showOnlyPanel("pnlBkDel");
		// Intentionally sending to first Subpanel as :  
		//   1 Global Obj 'listBkRet' cannot use for 2 subPanels : 'pnlBkDel_D' and After that 'pnlBkDel_E' without performing heavy DB action...
    }
    private void btnBack_pnlBkDel_EActionPerformed(java.awt.event.ActionEvent evt) {//  This method will called when : Book Deletion SubPanel's 'Back' btn is clicked...        
        showOnlyPanel("pnlBkDelNow");
    }

    private void btnCancel_pnlBkDel_EActionPerformed(java.awt.event.ActionEvent evt) {// This method will called when : Book Deletion SubPanel's 'Cancel' btn is clicked...        //  
		showOnlyPanel("pnlLogo");
    }//  

	
    private void btnSubmit_pnlBkDel_EActionPerformed(java.awt.event.ActionEvent evt) {// This method is to handle Book Deletion Final Submit...
    
        try{
                
                String bookInfos = listBkRet.get(0);
                String []arrBkDel = bookInfos.split("([\\^\\^\\^]+)");                                         /* // Explaination...At the time of Submission , Whatever index is selected in pnlBkDel_B... Fetch the Value from Global ListObject 'listBkRet' by .get(n) using Corresponding Index No, Use split() method to Store that Concatenated String into a String Array...

                        +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
                        | Book     | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn    | Price  | TransId | Author |
                        +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
                        | Cpp Book | 10002 |   101 |   5 | Bhatt  | 1010 | Fac. | Jul 16,2019 | 300.00 |     1   | Kallo  |
                arr[] : +-----0----+---1---+----2--+---3-+---4----+---5--+--6---+------7------+----8---+-----9---+---10---+            */
            int i=0;
            for(String s:arrBkDel)
                p("\n### arr "+ (i) +" =>" + arrBkDel[i++] + "<=");


            int accid = Integer.parseInt(arrBkDel[1]);
            int accno = Integer.parseInt(arrBkDel[2]);
            String feedBack = "";
            feedBack = updateStatusInTbl_books( accid, accno );                                                 
            // change the tbl_books status from 'I'ssued   OR   'A'vailable  to  'D'eleted...
            
            if( !feedBack.equals("1") ){
                p("\n### 3  Exception occ 1, feedBack =>"+feedBack);
                throw new Exception( feedBack );                                                                // throwing Exception or Error...
            }
            
            feedBack = "";
            feedBack = insertIntoTblBookDel( accid, accno, "MemberLostTheBook" );
            // In Table bkdel ... Make entry of that Members Id, Book Id ,Book No and Current Date...
            
            if( !feedBack.equals("1") ){
                p("\n### 6  Exception occ 2, feedBack =>"+feedBack);
                throw new Exception( feedBack );                                                                // throwing Exception or Error...
            }
            else{
                feedBack = "";
			// +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
			// | Book     | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn    | Price  | TransId | Author |
			// +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
                String bkShortName = "";
                if((arrBkDel[0].length()) < 14)
                    bkShortName = arrBkDel[0];
                else
                    bkShortName = arrBkDel[0].substring(10)+"...";
                feedBack = "A Book '"+ bkShortName + "'["+ arrBkDel[1] +"] is Deleted Successfully !";
                // Sending User on Home Page...
                lblBkD_errMsg.setText( feedBack );
                showOnlyPanel("pnlBkDel");
            }
        }catch(Exception e){
            lblBkR_B_err1.setText(e.getMessage());
            showOnlyPanel("pnlBkDel_E");
        }
    }//  

    private void btnRetBkRecv1ActionPerformed(java.awt.event.ActionEvent evt) {// 		 This method is called when 'Book Delete Subpanel E's 'ReceiveBtn' is Clicked
        
        if(btnRetBkRecv1.getText().equals("Receive")){
            btnRetBkRecv1.setText("Received");
            btnRetBkRecv1.setForeground(new Color(10,180,10));
        }
        else{
            btnRetBkRecv1.setText("Receive");
            btnRetBkRecv1.setForeground(new Color(250,10,10));
        }
    }//  

    public static void main(String args[]) {	// ----------------- Driver Method -----------------------	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }
	
    // Variables declaration ...//  
    private javax.swing.JButton btnBack_pnlBkDel_E;
    private javax.swing.JButton btnBkAdd;
    private javax.swing.JButton btnBkAddBack;
    private javax.swing.JButton btnBkAddSave;
    private javax.swing.JButton btnBkAdvEdit;
    private javax.swing.JButton btnBkAdvSer;
    private javax.swing.JButton btnBkD_back;
    private javax.swing.JButton btnBkD_back10;
    private javax.swing.JButton btnBkD_back2;
    private javax.swing.JButton btnBkD_back3;
    private javax.swing.JButton btnBkD_back4;
    private javax.swing.JButton btnBkD_back5;
    private javax.swing.JButton btnBkD_back6;
    private javax.swing.JButton btnBkD_back7;
    private javax.swing.JButton btnBkD_back8;
    private javax.swing.JButton btnBkD_back9;
    private javax.swing.JButton btnBkD_del;
    private javax.swing.JButton btnBkDel_D_Back;
    private javax.swing.JButton btnBkDel_D_Cancel;
    private javax.swing.JButton btnBkDel_D_Submit;
    private javax.swing.JButton btnBkDel_E;
    private javax.swing.JButton btnBkDel_E_back;
    private javax.swing.JButton btnBkE_back;
    private javax.swing.JButton btnBkE_showBks;
    private javax.swing.JButton btnBkE_update;
    private javax.swing.JButton btnBkFind;
    private javax.swing.JButton btnBkI_A_show;
    private javax.swing.JButton btnBkIssue;
    private javax.swing.JButton btnBkRemove;
    private javax.swing.JButton btnBkReturn;
    private javax.swing.JButton btnBkShow;
    private javax.swing.JButton btnBkShow_Go;
    private javax.swing.JButton btnBkShow_Go1;
    private javax.swing.JButton btnBkShow_Go2;
    private javax.swing.JButton btnBkShow_Go3;
    private javax.swing.JButton btnBkShow_Go4;
    private javax.swing.JButton btnBkShow_Go5;
    private javax.swing.JButton btnCancel_pnlBkDel_E;
    private javax.swing.JButton btnMAdd_bk;
    private javax.swing.JButton btnMAdd_reset;
    private javax.swing.JButton btnMAdd_submit;
    private javax.swing.JButton btnMemAdd;
    private javax.swing.JButton btnMemRemove;
    private javax.swing.JButton btnMemShow;
    private javax.swing.JButton btnReportBack;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnRetBkRecv;
    private javax.swing.JButton btnRetBkRecv1;
    private javax.swing.JButton btnSubmit_pnlBkDel_E;
    private javax.swing.JCheckBox checkRep_1;
    private javax.swing.JCheckBox checkRep_2;
    private javax.swing.JCheckBox checkRep_3;
    private javax.swing.JCheckBox checkRep_4;
    private javax.swing.JCheckBox chkMAdd_iss;
    private javax.swing.JComboBox<String> comboBkI_B;
    private javax.swing.JCheckBox comboBk_R_C;
    private javax.swing.JComboBox<String> comboMAdd;
    private javax.swing.JComboBox<String> comboRep1;
    private javax.swing.JComboBox<String> comboRep2;
    private javax.swing.JComboBox<String> comboRep3;
    private javax.swing.JComboBox<String> comboRep4;
    private javax.swing.JComboBox<String> comboRepSort1;
    private javax.swing.JComboBox<String> comboRepSort2;
    private javax.swing.JComboBox<String> comboRepSort3;
    private javax.swing.JComboBox<String> comboRepSort4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblBkD_errMsg;
    private javax.swing.JLabel lblBkDelE_Bid;
    private javax.swing.JLabel lblBkDelE_Bname;
    private javax.swing.JLabel lblBkDelE_Btype;
    private javax.swing.JLabel lblBkDelE_auth;
    private javax.swing.JLabel lblBkDelE_nAva;
    private javax.swing.JLabel lblBkDelE_nDes;
    private javax.swing.JLabel lblBkDelE_nIss;
    private javax.swing.JLabel lblBkDelE_nRep;
    private javax.swing.JLabel lblBkDelE_qty;
    private javax.swing.JRadioButton lblBkDelE_rbtnMem;
    private javax.swing.JRadioButton lblBkDelE_rbtnOth;
    private javax.swing.JLabel lblBkDel_E_Err;
    private javax.swing.JLabel lblBkDel_E_mid;
    private javax.swing.JLabel lblBkDel_E_mid1;
    private javax.swing.JLabel lblBkE_id;
    private javax.swing.JLabel lblBkEditErr;
    private javax.swing.JLabel lblBkEditNowErr;
    private javax.swing.JLabel lblBkErrSucc;
    private javax.swing.JTextField lblBkI_A_Data;
    private javax.swing.JLabel lblBkI_A_err;
    private javax.swing.JLabel lblBkI_B_err;
    private javax.swing.JLabel lblBkI_C;
    private javax.swing.JLabel lblBkI_D_err;
    private javax.swing.JTextField lblBkR_A_Data;
    private javax.swing.JLabel lblBkR_A_err;
    private javax.swing.JLabel lblBkR_B_err;
    private javax.swing.JLabel lblBkR_B_err1;
    private javax.swing.JLabel lblBkR_C_err;
    private javax.swing.JLabel lblBkShowBkQty;
    private javax.swing.JLabel lblBkShowBkStsA;
    private javax.swing.JLabel lblBkShowBkStsI;
    private javax.swing.JLabel lblBkShowBkStsR;
    private javax.swing.JLabel lblBkShowErr;
    private javax.swing.JLabel lblBkShowNBkQty;
    private javax.swing.JLabel lblBkShowNBkStsA;
    private javax.swing.JLabel lblBkShowNBkStsI;
    private javax.swing.JLabel lblBkShowNBkStsR;
    private javax.swing.JLabel lblBkShowNBks;
    private javax.swing.JLabel lblBkShowTotalBk;
    private javax.swing.JLabel lblBk_D_B_bAuth;
    private javax.swing.JLabel lblBk_D_B_bAvb;
    private javax.swing.JLabel lblBk_D_B_bId;
    private javax.swing.JLabel lblBk_D_B_bName;
    private javax.swing.JLabel lblBk_D_B_bType;
    private javax.swing.JLabel lblBk_I_C_bAuth;
    private javax.swing.JLabel lblBk_I_C_bAvb;
    private javax.swing.JLabel lblBk_I_C_bId;
    private javax.swing.JLabel lblBk_I_C_bName;
    private javax.swing.JLabel lblBk_I_C_bType;
    private javax.swing.JTextField lblBk_I_C_mDoj;
    private javax.swing.JTextField lblBk_I_C_mId;
    private javax.swing.JLabel lblBk_I_C_mName;
    private javax.swing.JLabel lblBk_I_D_bId;
    private javax.swing.JLabel lblBk_I_D_bIssDt;
    private javax.swing.JLabel lblBk_I_D_bNm;
    private javax.swing.JLabel lblBk_I_D_bNm2;
    private javax.swing.JLabel lblBk_I_D_bRetDt;
    private javax.swing.JLabel lblBk_I_D_bType;
    private javax.swing.JLabel lblBk_I_D_mAuth;
    private javax.swing.JLabel lblBk_I_D_mId;
    private javax.swing.JLabel lblBk_I_D_mNm;
    private javax.swing.JLabel lblBk_I_D_mNm2;
    private javax.swing.JLabel lblBk_I_D_mNm3;
    private javax.swing.JLabel lblBk_I_D_mNm4;
    private javax.swing.JLabel lblBk_R_B_bAuth;
    private javax.swing.JLabel lblBk_R_B_bAuth1;
    private javax.swing.JLabel lblBk_R_B_bDelay;
    private javax.swing.JLabel lblBk_R_B_bId;
    private javax.swing.JLabel lblBk_R_B_bId1;
    private javax.swing.JLabel lblBk_R_B_bIssDt;
    private javax.swing.JLabel lblBk_R_B_bIssDt1;
    private javax.swing.JLabel lblBk_R_B_bLastDt;
    private javax.swing.JLabel lblBk_R_B_bLastDt1;
    private javax.swing.JLabel lblBk_R_B_bLastDt2;
    private javax.swing.JLabel lblBk_R_B_bNm;
    private javax.swing.JLabel lblBk_R_B_bNm1;
    private javax.swing.JLabel lblBk_R_B_bNm2;
    private javax.swing.JLabel lblBk_R_B_bNm3;
    private javax.swing.JLabel lblBk_R_B_bRetDt;
    private javax.swing.JLabel lblBk_R_B_mId;
    private javax.swing.JLabel lblBk_R_B_mId1;
    private javax.swing.JLabel lblBk_R_B_mNm;
    private javax.swing.JLabel lblBk_R_B_mNm1;
    private javax.swing.JLabel lblBk_R_B_mType;
    private javax.swing.JLabel lblBk_R_B_mType1;
    private javax.swing.JLabel lblBk_R_C_1_Total;
    private javax.swing.JLabel lblBk_R_C_bAuth;
    private javax.swing.JLabel lblBk_R_C_bDelay;
    private javax.swing.JLabel lblBk_R_C_bId;
    private javax.swing.JLabel lblBk_R_C_bIssDt;
    private javax.swing.JLabel lblBk_R_C_bLastDt;
    private javax.swing.JLabel lblBk_R_C_bNm;
    private javax.swing.JLabel lblBk_R_C_bRetDt;
    private javax.swing.JLabel lblBk_R_C_mId;
    private javax.swing.JLabel lblBk_R_C_mNm;
    private javax.swing.JLabel lblBk_R_C_mType;
    private javax.swing.JLabel lblFineCalc;
    private javax.swing.JLabel lblFineCalc1;
    private javax.swing.JLabel lblFineInfo;
    private javax.swing.JLabel lblFineInfo1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMAddErr;
    private javax.swing.JLabel lblMIss_mName10;
    private javax.swing.JLabel lblMIss_mName11;
    private javax.swing.JLabel lblMIss_mName12;
    private javax.swing.JLabel lblMIss_mName13;
    private javax.swing.JLabel lblMIss_mName14;
    private javax.swing.JLabel lblMIss_mName15;
    private javax.swing.JLabel lblMIss_mName16;
    private javax.swing.JLabel lblMIss_mName17;
    private javax.swing.JLabel lblMIss_mName18;
    private javax.swing.JLabel lblMIss_mName19;
    private javax.swing.JLabel lblMIss_mName2;
    private javax.swing.JLabel lblMIss_mName20;
    private javax.swing.JLabel lblMIss_mName21;
    private javax.swing.JLabel lblMIss_mName22;
    private javax.swing.JLabel lblMIss_mName23;
    private javax.swing.JLabel lblMIss_mName24;
    private javax.swing.JLabel lblMIss_mName25;
    private javax.swing.JLabel lblMIss_mName26;
    private javax.swing.JLabel lblMIss_mName27;
    private javax.swing.JLabel lblMIss_mName28;
    private javax.swing.JLabel lblMIss_mName29;
    private javax.swing.JLabel lblMIss_mName3;
    private javax.swing.JLabel lblMIss_mName30;
    private javax.swing.JLabel lblMIss_mName31;
    private javax.swing.JLabel lblMIss_mName32;
    private javax.swing.JLabel lblMIss_mName33;
    private javax.swing.JLabel lblMIss_mName4;
    private javax.swing.JLabel lblMIss_mName5;
    private javax.swing.JLabel lblMIss_mName6;
    private javax.swing.JLabel lblMIss_mName7;
    private javax.swing.JLabel lblMIss_mName8;
    private javax.swing.JLabel lblMIss_mName9;
    private javax.swing.JLabel lblMetaInfoInBkDel_D;
    private javax.swing.JLabel lblRepDt;
    private javax.swing.JLabel lblRepDt2;
    private javax.swing.JLabel lblRetBook;
    private javax.swing.JLabel lblRetBook1;
    private javax.swing.JList<String> listBkDel_B;
    private javax.swing.JList<String> listBkDel_D;
    private javax.swing.JList<String> listBkR_B;
    private javax.swing.JList<String> listBkShow;
    private javax.swing.JList<String> listBkShow1;
    private javax.swing.JPanel pnlBkAdd;
    private javax.swing.JPanel pnlBkDel;
    private javax.swing.JPanel pnlBkDelE_m;
    private javax.swing.JPanel pnlBkDelE_o;
    private javax.swing.JPanel pnlBkDelNow;
    private javax.swing.JPanel pnlBkDel_B;
    private javax.swing.JPanel pnlBkDel_D;
    private javax.swing.JPanel pnlBkDel_E;
    private javax.swing.JPanel pnlBkE_Input;
    private javax.swing.JPanel pnlBkE_Input1;
    private javax.swing.JPanel pnlBkE_Input2;
    private javax.swing.JPanel pnlBkEdit;
    private javax.swing.JPanel pnlBkEditNow;
    private javax.swing.JPanel pnlBkI_A;
    private javax.swing.JButton pnlBkI_A_sub1;
    private javax.swing.JButton pnlBkI_A_sub2;
    private javax.swing.JPanel pnlBkI_B;
    private javax.swing.JButton pnlBkI_B_chgMem;
    private javax.swing.JButton pnlBkI_B_chgMem1;
    private javax.swing.JButton pnlBkI_B_chgMem2;
    private javax.swing.JButton pnlBkI_B_chgMem3;
    private javax.swing.JButton pnlBkI_B_chgMem4;
    private javax.swing.JButton pnlBkI_B_chgMem5;
    private javax.swing.JButton pnlBkI_B_sub1;
    private javax.swing.JPanel pnlBkI_C;
    private javax.swing.JPanel pnlBkI_D;
    private javax.swing.JPanel pnlBkIssue;
    private javax.swing.JPanel pnlBkR_C_sub1;
    private javax.swing.JPanel pnlBkR_C_sub2;
    private javax.swing.JPanel pnlBkR_C_sub3;
    private javax.swing.JPanel pnlBkRet;
    private javax.swing.JPanel pnlBkShow;
    private javax.swing.JPanel pnlBk_R_A;
    private javax.swing.JPanel pnlBk_R_B;
    private javax.swing.JPanel pnlBk_R_C;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlMAdd;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JPanel pnlParentBtns;
    private javax.swing.JPanel pnlReport;
    private javax.swing.JRadioButton radioR_C_dec;
    private javax.swing.JRadioButton radioR_C_inc;
    private javax.swing.JPanel repSub1;
    private javax.swing.JPanel repSub2;
    private javax.swing.JLabel reportErr;
    private javax.swing.JButton reportReset;
    private javax.swing.JButton reportSubmit;
    private javax.swing.JTextArea txtAreaBkDel_E;
    private javax.swing.JTextField txtBkAbout;
    private javax.swing.JTextField txtBkAuth1;
    private javax.swing.JTextField txtBkAuth2;
    private javax.swing.JTextField txtBkD_data;
    private javax.swing.JTextField txtBkDel_E_mid;
    private javax.swing.JTextField txtBkE_about;
    private javax.swing.JTextField txtBkE_auth1;
    private javax.swing.JTextField txtBkE_auth2;
    private javax.swing.JTextField txtBkE_name;
    private javax.swing.JTextField txtBkE_pages;
    private javax.swing.JTextField txtBkE_price;
    private javax.swing.JTextField txtBkE_pub;
    private javax.swing.JTextField txtBkE_qty;
    private javax.swing.JTextField txtBkE_rack;
    private javax.swing.JTextField txtBkE_type;
    private javax.swing.JTextField txtBkEdit_find;
    private javax.swing.JTextField txtBkI_B_data;
    private javax.swing.JLabel txtBkI_B_doi;
    private javax.swing.JLabel txtBkI_B_mId;
    private javax.swing.JLabel txtBkI_B_mNm;
    private javax.swing.JLabel txtBkI_B_mem;
    private javax.swing.JTextField txtBkName;
    private javax.swing.JTextField txtBkPages;
    private javax.swing.JTextField txtBkPrice;
    private javax.swing.JTextField txtBkPub;
    private javax.swing.JTextField txtBkQty;
    private javax.swing.JTextField txtBkRack;
    private javax.swing.JTextField txtBkRet_C_2_nDays;
    private javax.swing.JTextField txtBkRet_C_2_reason;
    private javax.swing.JTextField txtBkType;
    private javax.swing.JTextField txtMAdd_Addr;
    private javax.swing.JTextField txtMAdd_Class;
    private javax.swing.JTextField txtMAdd_Name;
    private javax.swing.JTextField txtMAdd_Ph1;
    private javax.swing.JTextField txtMAdd_Ph2;
    private javax.swing.JTextField txtMAdd_Rno;
    private javax.swing.JTextField txtMAdd_doj;
    private javax.swing.JTextField txtRepDD;
    private javax.swing.JTextField txtRepDD2;
    private javax.swing.JTextField txtRepMM;
    private javax.swing.JTextField txtRepMM2;
    private javax.swing.JTextField txtRepYYYY;
    private javax.swing.JTextField txtRepYYYY2;
    // End of variables declaration//  	
	
    public void p(String msg) {
        System.out.println(msg);
    }

    public void showOnlyPanel(String pnlName) {// This method is called to Show only that Panel whose Name is Given...
	
	//        allPanels = new JPanel[]{pnlParent,pnlLogo,pnlBkAdd,pnlBkIssue};
	//        allPanelsNames = new String []{"pnlParent","pnlLogo","pnlBkAdd","pnlBkIssue"};

        for (JPanel pnl : allPanels) {        // Hide all other Panels
            pnl.setVisible(false);
        }

        int iOfPanelComp = -1;
        for (String pnl : allPanelsNames) {   // Loop to get Index of "Which Panel will Display"...
            iOfPanelComp++;
            if (pnlName.equals(pnl)) {
                break;
            }
        }
        int x = 0, y = 119, width = 994, height = 679;
        allPanels[iOfPanelComp].setVisible(true);
        allPanels[iOfPanelComp].setBounds(x, y, width, height);

        p("Panel =>'" + allPanelsNames[iOfPanelComp] + "' will display Only and at...");
        JPanel t = allPanels[iOfPanelComp];
        java.awt.Rectangle r = t.getBounds();
        p("x =" + r.x + "  ,y= " + r.y + " , width=" + r.width + " height=," + r.height + " visibility = " + t.isVisible());
        p("++++++++++\n===========");
    }

    public void setPanels(){    			   // All panels Bounds = Parent Panels Bounds and All panels .setVisible = false;

        int x = 0, y = 119, width = 994, height = 679;
        for (JPanel temp : allPanels) {
            temp.setBounds(x, y, width, height);
            temp.setVisible(false);
        }
    }	

	
    public void clearFields(JTextField[] arrTxts) {// Method to reset TxtFlds
        for (JTextField temp : arrTxts) {
            temp.setText("");
        }
    }

    public boolean isEmptyFields(JTextField[] arrTxts) { // Method to Check : IsEmpty...
        for (JTextField temp : arrTxts) {
            if ((new String(temp.getText()).length()) == 0) {
                return true;
            }
        }
        return false;
    }

    public void showMsgOnLbl(String msg, JLabel lbl) {  //  Method to show Success or Error Msg on Label...
        lbl.setText(msg);
    }
	
    public int isInvalidBkAddFields() {
//        String bkName = txtBkName.getText();
//        String bkAuth2 = txtBkAuth2.getText();        
//        String bkType = txtBkType.getText();
//        String bkAuth1 = txtBkAuth1.getText();
//        String bkPub = txtBkPub.getText();
//        
//        String bkRack = txtBkRack.getText();
//        String bkQty = txtBkQty.getText();
//        String bkPages = txtBkPages.getText();
//        
//        String bkPrice = txtBkPrice.getText();        
        int retVal = 0;
//        if(bkName.matches(""))        
        return retVal;
    }

    public Connection getDbConnObj() {// Creating 'Connection' class' Reference Variable ...
        
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/librarydb";
        String dbUname = "root";
        String dbPass = "";
        try {
            // Calling a Static Method of class "Class" to Load the MySQL JDBC Driver ...
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, dbUname, dbPass);
        } catch (Exception e) {
            con = null;
        } finally {
            return con;
        }
    }

	
    public String[] getBooksRecords() {// To Get Books Records...
        String[] results = null;
        java.util.ArrayList<String> arrList = null;
        Connection con = getDbConnObj();
        Statement st = null;
        ResultSet rs = null;
        try {
            if (con == null) {
                throw new Exception("OOPs... Something went Wrong, Retry. ");
            }
            String sql = "Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code, sum(case  "
                    + "when b.status='I' then 1 else 0 end) as Issued, "
                    + "sum(case  when b.status='R' then 1 else 0 end) as Repair, "
                    + "sum(case  when b.status='D' then 1 else 0 end) as Destroyed, "
                    + "sum(case  when b.status='A' then 1 else 0 end) as Available "
                    + "From tbl_book_info a " + ""
                    + "left join tbl_books b on a.b_acc_id = b.accid "
                    + "group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;";
            p("\n Showing Books Query : \n" + sql);
            arrList = new java.util.ArrayList<>();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            String recordStr = "";
            if (rs == null || rs.next() == false) {
                throw new Exception("OOPs...No Book's Record found !");
            }

            do {
                recordStr = "" + rs.getString("BookName") + " - (" + rs.getInt("BookQty") + ") , "
                        + "Code - " + rs.getInt("Code") + " , Repair = " + rs.getInt("Repair")
                        + " , Issued = " + rs.getInt("Issued") + " , Available = " + rs.getInt("Available");
                arrList.add(recordStr);
                // arrList[0] = "10001 - Java (4),Rs. 399.00/-",
                // arrList[1] = "10002 - C++ (2),Rs. 199.00/-".
            } while (rs.next());
            results = new String[arrList.size()];
            for (int i = 0; i < arrList.size(); i++) {
                results[i] = arrList.get(i);
            }

            st = null;
            rs = null;
            // This Query will give Number of TotalBooks, TotalQty, Available Books, Issued Books, Repair Books
            sql = "Select (Select count(*) from tbl_book_info) TotalBooks,"
                    + "(Select count(*) from tbl_books) TotalQty,"
                    + "(Select count(*) from tbl_books where status='A') Available,"
                    + "(Select count(*) from tbl_books where status='I') Issued,"
                    + "(Select count(*) from tbl_books where status='R') Repair "
                    + "from dual";
            p("Again \n\nOther " + sql);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs == null || rs.next() == false) {
                throw new Exception("OOps...No Records found !");
            }
            p("TotalBooks = " + rs.getInt("TotalBooks"));
            p("TotalQty = " + rs.getInt("TotalQty"));
            p("Available = " + rs.getInt("Available"));
            p("Issued = " + rs.getInt("Issued"));
            p("Repair = " + rs.getInt("Repair"));

            lblBkShowNBks.setText("" + rs.getInt("TotalBooks"));
            lblBkShowNBkQty.setText("" + rs.getInt("TotalQty"));
            lblBkShowNBkStsA.setText("" + rs.getInt("Available"));
            lblBkShowNBkStsI.setText("" + rs.getInt("Issued"));
            lblBkShowNBkStsR.setText("" + rs.getInt("Repair"));
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            lblBkShowErr.setForeground(Color.red);
            showMsgOnLbl("OOps... Something Went Wrong Baba!", lblBkShowErr);
            lblBkShowErr.setVisible(true);
        } catch (Exception e) {
            lblBkShowErr.setForeground(Color.red);
            lblBkShowErr.setVisible(true);
            showMsgOnLbl(e.getMessage(), lblBkShowErr);
            results = new String[]{"OOps,Somthing went Wrong..."};
        } finally {
//            results = (String[])arrList.toArray();            
            return results;

        }
    }

    public void takeDataToSetEdit(ResultSet rs) {// Updating Book Record in DB...
        lblBkEditNowErr.setForeground(Color.red);
        lblBkEditNowErr.setVisible(false);
        txtBkE_qty.setEditable(false);
        txtBkE_qty.setToolTipText("To Increment: Click on \" +Book \",  To Decrement: Click on \" -Book \"");
        try {
            String bid = "Id : " + rs.getInt("b_acc_id");
            String bname = "" + rs.getString("b_name");
            String bqty = "" + rs.getInt("b_qty");
            String btype = rs.getString("b_type");
            String bauth1 = rs.getString("b_auth1");
            String bauth2 = "" + rs.getString("b_auth2");
            String bpub = rs.getString("b_pub");
            String bpages = "" + rs.getInt("b_pages");
            String brack = "" + rs.getInt("b_rack");
            String bprice = "" + rs.getDouble("b_price");
            String babout = rs.getString("b_about");

//            p("____________ DATA TO BE EDITED ____________");
//            p(bid +" AND "+ bname +" AND "+ bqty +" AND "+ btype  +" AND "+ bauth1  +" AND "+ 
//                bauth2  +" AND "+ bpub  +" AND "+ bpages  +" AND "+ brack  +" AND "+ bprice  +" AND "+ 
//                babout );
            lblBkE_id.setText(bid);
            txtBkE_name.setText(bname);
            txtBkE_type.setText(btype);
            txtBkE_rack.setText(brack);
            txtBkE_auth1.setText(bauth1);
            txtBkE_auth2.setText(bauth2);
            txtBkE_pub.setText(bpub);
            txtBkE_about.setText(babout);
            txtBkE_qty.setText(bqty);
            txtBkE_price.setText(bprice);
            txtBkE_pages.setText(bpages);
            showMsgOnLbl("Great ... Record Updated Successfully.", lblBkEditNowErr);
            rs.close();
        } catch (SQLException e) {
            showMsgOnLbl("OOPs...Something Went Wrong, Retry !", lblBkEditNowErr);
        } catch (Exception e) {
            showMsgOnLbl(e.getMessage(), lblBkEditNowErr);
        }
    }

	    public void takeDataToSetOnDel(ResultSet rs) {// Setting of Deletion Panel...
		
        lblBkEditNowErr.setForeground(Color.red);
        lblBkEditNowErr.setVisible(false);
        txtBkE_qty.setEditable(false);
        txtBkE_qty.setToolTipText("To Increase: Click on \" +Book \",  To Decrease: Click on \" -Book \"");
        try {
            String bid = "Id : " + rs.getInt("b_acc_id");
            String bname = "" + rs.getString("b_name");
            String bqty = "" + rs.getInt("b_qty");
            String btype = rs.getString("b_type");
            String bauth1 = rs.getString("b_auth1");
            String bauth2 = "" + rs.getString("b_auth2");
            String bpub = rs.getString("b_pub");
            String bpages = "" + rs.getInt("b_pages");
            String brack = "" + rs.getInt("b_rack");
            String bprice = "" + rs.getDouble("b_price");
            String babout = rs.getString("b_about");
			//            p("____________ DATA TO BE EDITED ____________");
			//            p(bid +" AND "+ bname +" AND "+ bqty +" AND "+ btype  +" AND "+ bauth1  +" AND "+ 
			//                bauth2  +" AND "+ bpub  +" AND "+ bpages  +" AND "+ brack  +" AND "+ bprice  +" AND "+ 
			//                babout );
            lblBkE_id.setText(bid);
            txtBkE_name.setText(bname);
            txtBkE_type.setText(btype);
            txtBkE_rack.setText(brack);
            txtBkE_auth1.setText(bauth1);
            txtBkE_auth2.setText(bauth2);
            txtBkE_pub.setText(bpub);
            txtBkE_about.setText(babout);
            txtBkE_qty.setText(bqty);
            txtBkE_price.setText(bprice);
            txtBkE_pages.setText(bpages);
            showMsgOnLbl("Great ... Record Updated Successfully.", lblBkEditNowErr);
            rs.close();
        } catch (SQLException e) {
            showMsgOnLbl("OOPs...Something Went Wrong, Retry !", lblBkEditNowErr);
        } catch (Exception e) {
            showMsgOnLbl(e.getMessage(), lblBkEditNowErr);
        }
    }

    public int isInvalidBkEditFields() {
		// Checking is remaining...
        return 0;   // No Error
    }

	    public boolean setDataOnBkDelPanel_B(ResultSet rs ) {	// Method that fetched Records of Books when Id / Name of Books was Entered...
        boolean retVal = false;
	/*  'rs' can have like...
	+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+        ...When Id was Entered
	| Code  | Name     | Qty | Type        | Author | Price  | Issued | Repairing | Destroyed | Available |
	+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
	| 10001 | Java book|   3 | Programming | lala   | 799.00 |      1 |         0 |         0 |         2 |
	+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
												OR
	+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+        ...When like 'Name' was Entered
	| Code  | Name     | Qty | Type        | Author | Price  | Issued | Repairing | Destroyed | Available |
	+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
	| 10003 | Cpp 1.17 |   5 | Programming | lalaji | 100.00 |      0 |         0 |         0 |         5 |
	| 10002 | Cpp Book |   5 | Programming | Kallo  | 300.00 |      2 |         0 |         0 |         3 |
	+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+     */
        listBkRet = null;                                         // A Global Object for sharing Data on Various SubPanels...
        listBkRet = new java.util.ArrayList<>();
        String listValue;
        try{
            do{
                String  accId = "" + rs.getInt("Code"),                        
                        bName = rs.getString("Name"),
                        bQty = "" + rs.getInt("Qty"),
                        bType = rs.getString("Type"),
                        bAuth = rs.getString("Author"),
                        bPrice = "" + rs.getDouble("Price"),
                        nIssued = "" + rs.getInt("Issued"),
                        nRepair = "" + rs.getInt("Repairing"),
                        nDestroyed = "" + rs.getInt("Destroyed"),
                        nAvailable = "" + rs.getInt("Available");
                String sep = "^^^"; // Data Separator to Avoid 

                listValue = accId + sep + bName + sep + bQty + sep + bType + sep + bAuth + sep + bPrice 
                            + sep + nIssued + sep + nRepair + sep + nDestroyed + sep + nAvailable;
                p("Delete books Info : List Value = \n"+ listValue); // listValue = "...";
                listBkRet.add(listValue);
            }while(rs.next());
            
            try {
                listBkDel_B.setModel(                                // This is a JListBox of BkDelPnl_B...
                    new javax.swing.AbstractListModel<String>() {
                        String[] strings = getDelBooksRecords("forBkDelPanel_B");

                        public int getSize() {  return strings.length;  }

                        public String getElementAt(int i) {    return strings[i];    }
                    }
                );
            } catch (Exception e) {
                p("Nominal Exception from 'del_Bk_2_JList setter'- ... May be IllegalArgumentException occured ~4660 when Setting String to ReturnSubPnl_B_Listbox ,err = >" + e.getMessage()+"<-");
            }
            listBkDel_B.setSelectedIndex(0);
            retVal=true;
        }catch (Exception e){
            p("Nominal Exception - ... May be IllegalArgumentException occured ~4660 when Setting String to ReturnSubPnl_B_Listbox ,err = " + e.getMessage());
        }
        return retVal;
    }

    public String getDate_DyDtMnYr(Calendar cd) {			// Method that Takes String dt as "Wed Jun 12 10:38:59 PDT 2019";  Returns as "Thu Jan 31,2019"
        String dt = "" + cd.getTime();      // Takes String dt as "Wed Jun 12 10:38:59 PDT 2019";  Returns as "Thu Jan 31,2019"
                                                        //         Index  = "0123456789012345678901234567"
        String day = dt.substring(0, 3);
        String mon = dt.substring(4, 7);
        String date = dt.substring(8, 10);
        String year = dt.substring(24);
        return (day + " " + mon + " " + date + "," + year);
        //Returns like:("Thu Jan 31,2019")
    }
    public String getDbInsertableDate(String day_mon_date_year) {// Method I/p : "day_mon_date_year"(String) , O/p : "yyyy-mm-dd"(String)...
        /*     This Function will take 'String Argument' as "day_mon_date_year" (eg
               : Thu Jan 31,2019 ) And Returns 'String' as 'yyyy-mm-dd' (eg:
               2019-01-31)
               Receives like:'Thu Jan 31 2019'
                    Index :"0123456789012345"   */
        String months = "   JanFebMarAprMayJunJulAugSepOctNovDec";
        //  "012345678901234567890123456789012345678" (Divided by / ) 3 = Num of Month        
        String mon = day_mon_date_year.substring(4, 7);
        String date = day_mon_date_year.substring(8, 10);
        String year = day_mon_date_year.substring(11);
        int numMonth = months.indexOf(mon) / 3;
        // p("In Func : "+date+"-"+numMonth+"-"+year);
        return (year + "-" + numMonth + "-" + date);            // Returns like : 2019-01-31
    }
    
    public String getDbInsertableCurrentDate() {	// Returns like "2019-08-30"
        String months[] = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"} ;
        Calendar cd = Calendar.getInstance();
        String date = ""+cd.getTime()+" ";				// "Wed Jun 12 10:38:59 PDT 2019 "        
p("\n%%%%% Date = >"+ date +"<=");				//  01234567890123456789012345678
        int currMM = -1;
        for(String s: months){
                currMM++;
                if( date.substring(4,7).equals(s) )
                        break; 
        }			
        String dd = date.substring(8,10);			// "12"
        String mm = "" + currMM;				// "6"	... MySQL converts it to "06"
        String yyyy = date.substring(24,28);			// "2019"
p("\n%%%%% yyyy-mm-dd=>"+ yyyy +"-"+ mm +"-"+ dd +"<=");
        return ( yyyy +"-"+ mm +"-"+ dd );
    }

    public Calendar getPossible_DateOfRet(Calendar cd) {// Method that ensures : There is No Sunday on Book Returning Date...
        String dt = getDate_DyDtMnYr(cd); 		// Can Returns like : "Sun Mar 01,2019"
        String day = dt.substring(0, 3);
        if (day.equalsIgnoreCase("Sun")) {
            p("\n Incrementing 1 Day as Found Sunday on " + cd.getTime());
            cd.add(Calendar.DATE, 1);
        } else {
            p("\n Not Incrementing 1 day...");
        }
        return cd;					// Will Returns like : 'Mon Mar 01,2019'
    }
    
    public String getDateAsMonDateYear(String yyyy_mm_dd){          // Takes as  :  "2019-03-27" and  Returns as = "Mar 27,19" 
        String months[] = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"} ;
        String arr [] = yyyy_mm_dd.split("([-])");
        String retDate="";                                          // for(int i = 0; i<3; i++) p("arr["+i+"] = "+ arr[i]);

        retDate = months[Integer.parseInt(arr[1])];		    // retDate holds = "Mar"

        retDate += " "+arr[2];					    // retDate holds = "Mar 27"

        retDate += "," + arr[0].charAt(2) + "" + arr[0].charAt(3);  // retDate holds = "Mar 27,19"
        
        return retDate;      					    // Returns as = "Mar 27,19"
    }

	
    public void showIssPanel(String mName, int mId, char mType) {	// Shows Issue Panel...
        showOnlyPanel("pnlBkIssue");
        pnlBkI_A.setVisible(false);
        pnlBkI_C.setVisible(false);
        pnlBkI_D.setVisible(false);
        pnlBkI_B.setVisible(true);

        Calendar cd = Calendar.getInstance();	// Todays' Date like: "Wed Jun 12 10:38:59 PDT 2019"
        String mon_date_year = getDate_DyDtMnYr(cd);	// Returns like : "Wed Jan 29,2019";
        txtBkI_B_doi.setText(mon_date_year);
        txtBkI_B_mNm.setText(mName);
        txtBkI_B_mId.setText("[" + mType + "] " + mId);

    }

    public void showBtnOfIssue_A(JButton btn, ResultSet rs) {
        /*  This Method will Display a Button :
        When Teacher Came for issuing a book and Already Issued a book Earlier 
        then Button['Show Details'] will help to get the Transation of that previously issued Book
         */
        try {
            rs.first();
            btn.setVisible(true);
            if (rs.getString("TypeOfMember").equalsIgnoreCase("S")) {
                // Show Adv.Display Panel : with Student Member --> rs.getInt("M_Id") and Data rs
                p("Show Adv.Display Panel:with Student-> rs.getInt(\"M_Id\") & rs");
            } else {
                // Show Adv.Display Panel : with Student Member --> rs.getInt("M_Id") and Data rs
                p("Show Adv.Display Panel:with Teacher-> rs.getInt(\"M_Id\") & rs");
            }
        } catch (Exception e) {

        }
    }

    public void issueBook(ResultSet rs) {				// Set fields to Issue Panel...
        try {
            rs.first();
            String rsMid = "" + rs.getInt("M_Id");
            String rsMember = rs.getString("Member");
            String rsTypeOfMember = rs.getString("TypeOfMember");
            Calendar cd = Calendar.getInstance();
            String issueDt = getDate_DyDtMnYr(cd);

            txtBkI_B_data.setText("");
            txtBkI_B_mId.setText("[" + rsTypeOfMember + "] " + rsMid);
            txtBkI_B_mNm.setText(rsMember);
            txtBkI_B_doi.setText(issueDt);
            lblBkI_B_err.setVisible(false);
        } catch (Exception e) {
            lblBkI_B_err.setForeground(Color.red);
            lblBkI_B_err.setVisible(true);
            p(e.getMessage());
            showMsgOnLbl("OOPs... Some field might set Inproperly, Retry !", lblBkI_B_err);
        }
    }
    public int setBookIssue_C(int selectedIndex) {
        //      This method will Fire the Query on the Basis of SelectedIndex of ComboBox & Set FetchedData to SubPnl_C
        //      Combo Elements : Select Conditoin, Id, Name, Type, Author
        //               Index :             0   , 1 ,  2  ,  3  ,   4
            int ret = 0;
            final java.util.ArrayList<String> arrListIss_C;
    
            try {
                Connection con = getDbConnObj();
                if (con == null)
                    return -1;      // OOPs... Connection Error 
                
                Statement st = null;
                ResultSet rs = null;
                arrListIss_C = new java.util.ArrayList<>();
                String preFix, inFix = "", suFFix;
                preFix = "Select a.b_acc_id Code,a.b_name BookName, a.b_qty BookQty, a.b_auth1 as Author1 , a.b_auth2 as Author2 , a.b_type as BookType, "
                        + "sum(case  when b.status='I' then 1 else 0 end) as Issued, "
                        + "sum(case  when b.status='R' then 1 else 0 end) as Repair, "
                        + "sum(case  when b.status='D' then 1 else 0 end) as Destroyed, "
                        + "sum(case  when b.status='A' then 1 else 0 end) as Available "
                        + "From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid";
    
                suFFix = " group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;";
                String data = txtBkI_B_data.getText();
    
    //      Combo Elements : Select Conditoin , Id, Name, Type, Author
    //               Index :             0    , 1 ,  2  ,  3  ,   4
                switch (selectedIndex) {
                    case 1: {
                        inFix = " where a.b_acc_id = " + Integer.parseInt(data);
                        break;
                    }
                    case 2: {
                        inFix = " Where a.b_name like '%" + data + "%'";
                        break;
                    }
                    case 3: {
                        inFix = " Where a.b_type like '%" + data + "%' ";
                        break;
                    }
                    case 4: {
                        inFix = " Where a.b_auth1 like '%" + data + "%' or a.b_auth2 like '%" + data + "%'";
                        break;
                    }
                }
                String sql = preFix + inFix + suFFix;
    
                p(sql);     // If Searched By Id = 10005 then SQL Query : Select a.b_acc_id Code,a.b_name BookName, a.b_qty BookQty, a.b_auth1 as Author1 , a.b_auth2 as Author2 , a.b_type as BookType, sum(case  when b.status='I' then 1 else 0 end) as Issued, sum(case  when b.status='R' then 1 else 0 end) as Repair, sum(case  when b.status='D' then 1 else 0 end) as Destroyed, sum(case  when b.status='A' then 1 else 0 end) as Available From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid where a.b_acc_id = 10005 group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;
    
                st = con.createStatement();
                rs = st.executeQuery(sql);
    
                //Checking if This Data Exists in Book_Table...
                if(rs == null || rs.next() == false) 
                    return -2;      // OOPs... No such Found !
    
                String listValue;
                String author = "", dbAuthor1, dbAuthor2;
                int i = 0;
    
                if(selectedIndex == 1)   // Searched By BookId ...
                    if(rs.getInt("Available") == 0) 
                        return -3;      // OOPs... No Books Available with this Id
                do {
                // Code, BookName, Author1, Author2, BookType, BookQty, Issued, Repair, Destroyed, Available
                // Managing Which Author Will Display when Search Condition = Author
    
                // If - No Books Available with this Id -.-
                    if (Integer.parseInt("" + rs.getInt("Available")) == 0)
                        continue;      // Do Not Add this Book Details to ArrayList [and ListBox]
    
                    if (selectedIndex == 4) {         // At subPnl_B : Search_Condition = "Author"
                        dbAuthor1 = rs.getString("Author1");
                        dbAuthor2 = rs.getString("Author2");
                        if (dbAuthor1.matches("^(.*)?" + data + "(.*)?$")) 
                            author = dbAuthor1;
                        else
                            author = dbAuthor2;
                        
                    } else
                        author = rs.getString("Author1");
                                                   //^set Which Of the author( Auth1 || Auth2) will Display on ListBox
    
                    listValue = rs.getString("BookName") + " [" + rs.getInt("Code") + "] - "
                            + author + " ( " + rs.getInt("Available") + " ) : " + rs.getString("BookType");
    
                    //Arraylist me add karo
                    arrListIss_C.add(listValue);                
                } while (rs.next());                  	// Here, All rows Ended : Cursor reached after Last Row            
                
                p("Reached ---> After pnl_B_ next : arrListIss_C.length = " + arrListIss_C.size());		// print msg on console
    
                if (arrListIss_C.size() == 0) 
                    return -2;                      	// OOPs... No Books Available with this Data
    
                try {
                    listBkShow1.setModel(
                            new javax.swing.AbstractListModel<String>() {
                        String[] strings = getIssRetBooksRecords("atIssue", arrListIss_C);
    
                        public int getSize() {
                            return strings.length;
                        }
    
                        public String getElementAt(int i) {
                            return strings[i];
                        }
                    }
                    );
                } catch (Exception e) {
                    p("Nominal Exception -  ... May be IllegalArgumentException occured ~4860 when Setting String to IssueSubPnl_C on " + e.getMessage());
                }
    
                p("\n ---- reached After listBkShow1.setModel");
                listBkShow1.setSelectedIndex(0);
                rs.first();
    
                // Code, BookName, Author1, Author2, BookType, BookQty, Issued, Repair, Destroyed, Available            
                lblBk_I_C_bId.setText("" + rs.getInt("Code"));
                lblBk_I_C_bName.setText("" + rs.getString("BookName"));
                lblBk_I_C_bAuth.setText("" + author);
                lblBk_I_C_bType.setText("" + rs.getString("BookType"));
                lblBk_I_C_bAvb.setText("" + rs.getInt("Available"));
                
                //Panel C : Date,Member,MemId:            
                lblBk_I_C_mDoj.setText(txtBkI_B_doi.getText());
                lblBk_I_C_mName.setText(txtBkI_B_mNm.getText());
                lblBk_I_C_mId.setText(txtBkI_B_mId.getText());
    
                // This Fun -.- : Each Time When List's Selected Index changes : Related Label's Values must be Changed                        
                ret = 1;              // Okay ( Go Further : Not to Print )
    
            } catch (IllegalArgumentException e) {
                p("major Exception -  ... IllegalArgumentException occured ~4860 when Setting String to IssueSubPnl_C on " + e.getMessage());
            } catch (Exception e) {
                p("New Warning ... Exception occured ~4860 when Setting String to IssueSubPnl_C on " + e.getMessage());
                ret = 0;            // OOPs... Data could not Fetched Properly, Retry !
            }
            return ret;
        }
        public String[] getIssRetBooksRecords(String atWhen, java.util.ArrayList<String> listBkRet) {
            p("1) Reached in getIssRetBooksRecords()");
            if (atWhen.equals("atIssue")) {                  // Method Called from Issue Section 
                String listVal = "Java book [10001] - lala ( 2 ), Programming";            
                String[] results = null;                    // Storing ArrayList Elements to String Array for parameters
                results = new String[listBkRet.size()];
                for (int i = 0; i < listBkRet.size(); i++) 
                    results[i] = listBkRet.get(i);           
    
                return results;
            } else {    		                           // Method Called From Return Section 
    
                String timeStatus, listVal = "1002^^^Shubhu^^^T^^^10002^^^101^^^Cpp Book^^^Kallo^^^2019-06-21^^^2019-07-22^^^2019-08-01^^^10";
                //               "1002   Shubhu   T   10002   101   Cpp Book   Kallo   2019-06-21   2019-07-22   2019-08-01   10";
                //          temp [  0       1     2     3      4        5        6          7           8            9        10  ];
    
                String[] results = null;                    // Storing ArrayList Elements to String Array for parameters
                String[] arrBkRet = null;
                results = new String[listBkRet.size()];
                int i;
                // Spliting ResultArray and storing in ListObject...
                for (i = 0; i < listBkRet.size(); i++) {
                    arrBkRet = (listBkRet.get(i)).split("([\\^\\^\\^]+)");
                    timeStatus = getTimeLeftToReturn(Integer.parseInt(arrBkRet[10]));
                    results[i] = arrBkRet[5] + " [" + arrBkRet[3] + " ]-" + arrBkRet[6] + ", " + arrBkRet[7] + " to " + arrBkRet[8] + ", (" + timeStatus + ")";
                }
                return results;
            }
        }
        public String[] getRetBooksRecords() {

            String timeStatus, listVal = "1002^^^Shubhu^^^T^^^10002^^^101^^^Cpp Book^^^Kallo^^^2019-06-21^^^2019-07-22^^^2019-08-01^^^10";
            p("\tReached listBkShow1.setModel(fun getIssRetBooksRecords())");
            //               "1002   Shubhu   T   10002   101   Cpp Book   Kallo   2019-06-21   2019-07-22   2019-08-01   10";
            //          temp [  0       1     2     3      4        5        6          7           8            9        10  ];
            String[] results = null;                    // Storing ArrayList Elements to String Array for parameters
            String[] arrBkRet = null;
            results = new String[listBkRet.size()];
            int i;
            for (i = 0; i < listBkRet.size(); i++) {
    //  'arrBkRet' will Become : Array of 11 String Objects
                arrBkRet = (listBkRet.get(i)).split("([\\^\\^\\^]+)");
                timeStatus = getTimeLeftToReturn(Integer.parseInt(arrBkRet[10]));
                results[i] = arrBkRet[5] + " [" + arrBkRet[3] + " (" + arrBkRet[4] + ") ]-" + arrBkRet[6] + ", " + arrBkRet[7] + " to " + arrBkRet[8] + ", (" + timeStatus + ")";
            }
            return results;
        }
        public String[] getDelBooksRecords(String condition) {  // "forBkDelPanel_B"  or "forPnlBk_D"        
    
        p("%%%% 2.8.3.1 Reached getDelBooksRecords(\"forBkDelPanel_D\")");
        if(condition.equals("forBkDelPanel_B")){                        // "forBkDelPanel_B"  <--  search by this
            
            String results[] = null, arrBkDel[] = null;
            String listVal = "10001^^^Java book^^^3^^^Programming^^^lala^^^799.00^^^1^^^0^^^0^^^2";
                    //                         10001   Java book     3   Programming   lala     799.00       1           0            0        2
                    //  listBkDel.split("^^^")=[ 0       1           2      3            4        5          6           7            8        9   ];
            results = new String[listBkRet.size()];
            int i;
            for (i = 0; i < listBkRet.size(); i++) {
                    //  'arrBkDel' will Become : Array of 11 Strings
                arrBkDel = (listBkRet.get(i)).split("([\\^\\^\\^]+)");//7350
                    //  arrBkDel[]=  [ 0       1           2      3            4        5          6           7            8        9   ];
                    //               10001   Java book     3   Programming   lala     799.00       1           0            0        2
                results[i] = arrBkDel[1] + " [ " + arrBkDel[0] + " ]( " + arrBkDel[3] + " ) - " + arrBkDel[4] + " : Rs " + arrBkDel[5] ;
                    /*  In JListBox : 0th Index'll hold :-> Java book [ 10001 ](Programming) - lala : 799.00
                            Index at List               :->     1         0          3          4       5       */
            }
            return results;
        }
        
        else{                                                           // "forBkDelPanel_D"  <--  search by this
        /*  Data => Cpp Book^^^10002^^^102^^^5^^^shubh^^^1008^^^Fac.^^^Jul 16,19^^^300.00^^^2^^^KalloAuth<= , ... , ...     you need to set useful info from all these ArrayList listBkRet values to JListBox as String Array : results[]
            Array=> arr[ 0 ] =>Cpp Book<=   arr[ 1 ] =>10002<=      arr[ 2 ] =>102<=    arr[ 3 ] =>5<=     arr[ 4 ] =>shubh<=   arr[ 5 ] =>1008<=   arr[ 6 ] =>Fac.<=    arr[ 7 ] =>Jul 16,19<=  arr[ 8 ] =>300.00<=     arr[ 9 ] =>2<=    arr[ 10 ] =>KalloAuth<=     */
            
            String results[] = null, arrBkDel[] = null;
            String listVal = "Cpp Book^^^10002^^^102^^^5^^^shubh^^^1008^^^Fac.^^^Jul 16,19^^^300.00^^^2^^^KalloAuth";// = listBkRet.get(0);

            results = new String[listBkRet.size()];
            int i;
            for (i = 0; i < listBkRet.size(); i++) {
            //  'arrBkDel' will Become : Array of String Objects
                arrBkDel = (listBkRet.get(i)).split("([\\^\\^\\^]+)");//7350
                            /*      +----0------+---1---+---2---+--3--+---4----+--5---+--6---+----7------+---8----+----9----+---10---+
                                    | Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId | Author |
                                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
                                    | Cpp Book  | 10002 |   102 |   5 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |       2 | Kallo  |
                                    | Java book | 10001 |   103 |   3 | shubh  | 1008 | Fac. | Jul 19,19 | 799.00 |       5 | lala   |
                                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
                    arrBkDel[]=>  [     0       1           2      3            4        5          6           7            8        9   10  ];
                    Array   =>      Cpp Book  10002        102     5          shubh    1008        Fac.     Jul 16,19     300.00      2  Kallo   */
                results[i] = arrBkDel[0] + " [ " + arrBkDel[1] + " ] - " + arrBkDel[10] + " ( Issued On : " + arrBkDel[7] +" )" ;
                    /*  In JListBox : 0th Index'll hold :-> Cpp Book [10002] - Kallo (Issued On : Jul 16,19)
                            Index at List               :->  */
            }
            return results;
        }
    }
    public void setComps_Issue_C_OnListChange() {
        String nextName, nextId, nextAuth, nextAbl, nextType,
               listVal = listBkShow1.getSelectedValue(); //eg: listVal = "Cpp 1.17 [10003] - lalaji ( 3 ) : Programming
        String arr[] = listVal.split("\\[");
        nextName = arr[0];		// Name of Book 
        arr = arr[1].split("\\]");
        nextId = arr[0];		// Id of Book 
        arr = arr[1].split(" \\(");
        nextAuth = arr[0].substring(3, arr[0].length());
        arr = arr[1].split(" \\)");
        nextAbl = arr[0].substring(1, arr[0].length());
        arr = arr[1].split(": ");
        nextType = arr[1];

        lblBk_I_C_bId.setText("" + nextId);
        lblBk_I_C_bName.setText("" + nextName);
        lblBk_I_C_bAuth.setText("" + nextAuth);
        lblBk_I_C_bType.setText("" + nextType);
        lblBk_I_C_bAvb.setText("" + nextAbl);
    }    
    public void setComps_Find_C_OnListChange() {
        String nextName, nextId, nextAuth, nextAbl, nextType,
               listVal = listBkShow2.getSelectedValue(); //eg: listVal = "Cpp 1.17 [10003] - lalaji ( 3 ) : Programming
        String arr[] = listVal.split("\\[");
        nextName = arr[0];		// Name of Book 
        arr = arr[1].split("\\]");
        nextId = arr[0];		// Id of Book 
        arr = arr[1].split(" \\(");
        nextAuth = arr[0].substring(3, arr[0].length());
        arr = arr[1].split(" \\)");
        nextAbl = arr[0].substring(1, arr[0].length());
        arr = arr[1].split(": ");
        nextType = arr[1];
		
        lblBk_I_C_bId1.setText("" + nextId);
        lblBk_I_C_bName1.setText("" + nextName);
        lblBk_I_C_bAuth1.setText("" + nextAuth);
        lblBk_I_C_bType1.setText("" + nextType);
        lblBk_I_C_bAvb1.setText("" + nextAbl);
    }

    public void setComps_DelBk_B_OnListChange() {                                                                                           /*
        Desc              : b_acc_id    Book        Qty     Type      Author    Price    Issued    Repairing     Destroyed  Available ... b_acc_id    Book    Qty .....
        rowData[0->9]     :    10001   Java book     3   Programming   lala     799.00       1           0            0        2      ...  10003      Cpp      5  .....
        rowData's Indices :   [ 0       1            2      3            4        5          6           7            8        9   ]; ... [  10        11      12  .....
        In JListBox : 0th Index'll hold :-> Java book [ 10001 ](Programming) - lala : 799.00
        Index at List                   :->     1         0          3          4       5                                                   */
        int selInd = listBkDel_B.getSelectedIndex();
        //          Global Object: listBkRet[n].get(0) = "10001^^^Java book^^^3^^^Programming^^^lala^^^799.00^^^1^^^0^^^0^^^2"
        String []rowData = (listBkRet.get( selInd )).split("([\\^\\^\\^]+)");
        //          rowData[0->9]     :    10001   Java book     3   Programming   lala     799.00       1           0            0        2      ...  10003      Cpp      5  .....
        //          rowData's Indices :   [ 0       1            2      3            4        5          6           7            8        9   ]; ... [  10        11      12  .....

            lblBk_D_B_bId.setText(   rowData[0]);
            lblBk_D_B_bName.setText( rowData[1]);
            lblBk_D_B_bAuth.setText( rowData[4]);
            lblBk_D_B_bType.setText( rowData[6]);
            lblBk_D_B_bAvb.setText(  rowData[9]);
    }
    public String getTimeLeftToReturn(int val) {
        // Possible Values of 'Val' = ... -2,-1,0,1,2, ...
        String timeStatus = "";
        if (val < 0) // Late
        {
            return ((val * (-1)) + " Days LATE");
        } else // On Time
        {
            return (val + " Days Left");
        }
    }
    public void setBkRetListLabels(int selInd) {
        //+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+
        //| m_Id | Member | MemberType | accid | accno | Book     | Author | issuedOn    | lastDate    | Today       | daysDelayed |
        //+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+
        //| 1002 | Shubhu | T          | 10002 |   101 | Cpp Book | Kallo  | Jun 21,2019 | Jul 22,2019 | Jul 29,2019 |          -7 |
        //| 1002 | Shubhu | T          | 10002 |   102 | Cpp Book | Kallo  | Jun 17,2019 | Jul 18,2019 | Jul 29,2019 |         -11 |
        //+------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+
    
        /*       listBkRet.get( 0 )= "1002^^^Shubhu^^^T^^^10002^^^101^^^Cpp Book^^^Kallo^^^Jun 21,2019^^^Jul 22,2019^^^2019-08-01^^^10";
        arr=split("[^^^]+")= "1002   Shubhu   T   10002   101   Cpp Book   Kallo   Jun 21,2019   Jul 22,2019   Jul 29,2019  -7  ";
                   temp     [   0       1     2     3      4        5        6          7             8              9      10  ]; */
            String[] arrBkRet;
            arrBkRet = (listBkRet.get(selInd)).split("([\\^\\^\\^]+)");
            p("===> list val changed...");
            int i = 0;
            for (String s : arrBkRet) {
                p("arrBkRet " + (i++) + " = " + s);
            }
            lblBk_R_B_mId.setText(arrBkRet[0]);
            lblBk_R_B_mNm.setText(arrBkRet[1]);
            lblBk_I_D_mNm3.setText(arrBkRet[1]);
    
            lblBk_R_B_bId.setText(arrBkRet[3]);
            lblBk_R_B_bNm.setText(arrBkRet[5]);
            lblBk_R_B_bNm2.setText(arrBkRet[5]);
    
            if (arrBkRet[2].equalsIgnoreCase("T")) {
                lblBk_R_B_mType.setText("Teacher");
            } else {
                lblBk_R_B_mType.setText("Student");
            }
    
            lblBk_R_B_bAuth.setText(arrBkRet[6]);
            lblBk_R_B_bIssDt.setText(arrBkRet[7]);
            lblBk_R_B_bLastDt.setText(arrBkRet[8]);
            lblBk_R_B_bRetDt.setText(arrBkRet[9]);
            int nDaysLeft = Integer.parseInt(arrBkRet[10]);
            if (nDaysLeft < 0) {
                //  Member('S' or 'T') is n Days Late -
                lblBk_R_B_bDelay.setForeground(new Color(235, 0, 0));
                lblBk_R_B_bDelay.setText("Late: " + (nDaysLeft * (-1)) + " Day(s)");
                if (arrBkRet[2].equals("S") == true) //  Fine will Only charged for --> Students , Not for --> Teachers
                    pnlBkI_B_sub1.setText("Next");    //  Bring Student on Fine Panel
                else
                    pnlBkI_B_sub1.setText("Return");  //  Return Book From Teacher
            } else {
                //  Member('S' or 'T') is On Time     -
                lblBk_R_B_bDelay.setForeground(new Color(20, 140, 20));
                lblBk_R_B_bDelay.setText("On Time( " + nDaysLeft + " )");
                pnlBkI_B_sub1.setText("Return");  //  Return Book From 'S' OR 'T'
            }
            //  List box me This Member ko Issue ki gyi Book(s for 'T') ka Detail feed hone and Rel.Lbls Set hone k baad,
            //  Now just Submit and show next "Fine Panel"...
        }
        public void setPnlB_R_C_1() {	// Book_Return_subpanel_C_1
            lblBk_R_C_mId.setText(lblBk_R_B_mId.getText());
            lblBk_R_C_bId.setText(lblBk_R_B_bId.getText());
            lblBk_R_C_mNm.setText(lblBk_R_B_mNm.getText());
            lblBk_R_C_bNm.setText(lblBk_R_B_bNm.getText());
            lblBk_R_C_mType.setText(lblBk_R_B_mType.getText());
            lblBk_R_C_bAuth.setText(lblBk_R_B_bAuth.getText());
            lblBk_R_C_bIssDt.setText(lblBk_R_B_bIssDt.getText());
            lblBk_R_C_bLastDt.setText(lblBk_R_B_bLastDt.getText());
            lblBk_R_C_bRetDt.setText(lblBk_R_B_bRetDt.getText());
            lblBk_R_C_bDelay.setText(lblBk_R_B_bDelay.getText());   // 'n Days Late' OR 'On Time( n )'
            comboBk_R_C.doClick();
    //      Setting infos on SubPnls of BkRet_C_                    // Index=  012345678901234
            String data = lblBk_R_C_bDelay.getText();                // data = "Late: 10 Day(s)"
            String start = data.substring(6);                       // start =      "10 Day(s)"
            int numDays = Integer.parseInt(start.substring(0, start.indexOf(" ")));//     10
            lblFineInfo.setText("Fine for " + numDays + " day(s)");
            lblFineCalc.setText("Rs 2 x " + numDays);
            lblBk_R_C_1_Total.setText("Rs " + (2 * numDays));
            lblBk_R_B_bLastDt1.setText(lblBk_R_B_bLastDt.getText());
        }
        public void setRet_C_SubPnl(int subPnlNo) {
            //  This method will Reset the SubPnl of ReturnBook_C
            if (subPnlNo == 1) {
                btnRetBkRecv.setText("Receive");
                btnRetBkRecv.setForeground(new Color(255, 0, 0));
            } else {
                radioR_C_inc.setSelected(false);
                radioR_C_dec.setSelected(false);
                txtBkRet_C_2_nDays.setText("0");
                txtBkRet_C_2_reason.setText("Because of ");
            }
        }

          public void returnBookFromSubPnl(int subPnlNo) {
            try{
                p("\n'returnBookFromSubPnl(int subPnlNo)' invoked");     // t_id
                Connection con = getDbConnObj();
                if (con == null)
                    throw new Exception("OOPs... Connection Error, Check and Retry !");
                
                Statement st = con.createStatement();
                PreparedStatement pstmt = null;
                int aff = -1;       // Set to -1 To Demonstrate : No Database Action Performed ...

                /*   arrBkRet
                    +------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
                    | m_Id | Member | MemberType | accid | accno | Book     | Author | issuedOn    | lastDate    | Today       | daysDelayed | t_id |
                    +------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
                    | 1001 | Lala   | S          | 10003 |   101 | Cpp 1.17 | lalaji | Jun 21,2019 | Jul 22,2019 | Aug 02,2019 |         -11 |   16 |
                    +------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
                    listBkRet.get( 0 ) =  "1002^^^Shubhu^^^T^^^10002^^^101^^^Cpp Book^^^Kallo^^^Jun 21,2019^^^Jul 22,2019^^^2019-08-01^^^-11^^^16";
                    arr= split("[^^^]+")= "1002   Shubhu   T   10002   101   Cpp Book   Kallo   Jun 21,2019   Jul 22,2019   Jul 29,2019  -11   16   ";
                        arrBkRet   =  [   0       1     2     3      4        5        6          7             8              9       10   11 ]; */
                String[] arrBkRet;
                int selInd = listBkR_B.getSelectedIndex();
                arrBkRet = (listBkRet.get(selInd)).split("([\\^\\^\\^]+)");

                // p("\nReturn For Mem_trans_id : " + arrBkRet[11]);     // t_id
                int fine, tid, accid, accno;
                fine = Integer.parseInt(lblBk_R_C_1_Total.getText().substring(3));
                tid = Integer.parseInt(arrBkRet[11]);
                accid = Integer.parseInt(arrBkRet[3]);
                accno = Integer.parseInt(arrBkRet[4]);

                if (subPnlNo == 1) {
                    //          Fire Queries regarding RetBk_C_Subpanel_1 :
                    //                        p("set autocommit = 0;savepoint retBack;");
                    String sql = "Update bktrans "
                            + "Set m_actRetDt = DATE(sysdate()), "
                            + "m_fine = ?,"
                            + "m_delayCause = null, "
                            + "m_nPropDt = null "
                            + "Where t_id = ?;";
                    //                        p("Retun Book subpnl1 Query 1 = \n"+sql);
                    pstmt = null;
                    pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, fine);
                    pstmt.setInt(2, tid);
                    if (pstmt.executeUpdate() == 0)
                        throw new Exception("OOPs... Could Not Save Information, Retry 1_1!");
                    
                    sql = "UPDATE tbl_books "
                            + "SET status = 'A' "
                            + "WHERE accid = ? AND accno = ?;";
                    pstmt = null;
                    pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, accid);
                    pstmt.setInt(2, accno);
                    if (pstmt.executeUpdate() == 0) {
                        throw new Exception("OOPs... Could Not Save Information, Retry 1_2!");    // Rollback is needed...
                    }//  Till Here Both the tables 'bktrans' and 'tbl_books' are Updated Successfully, Now back to Home Page...
                    lblBkR_A_err.setForeground(new Color(20, 140, 20));
                    /*   arrBkRet
                        +------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
                        | m_Id | Member | MemberType | accid | accno | Book     | Author | issuedOn    | lastDate    | Today       | daysDelayed | t_id |
                        +------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+
                        | 1001 | Lala   | S          | 10003 |   101 | Cpp 1.17 | lalaji | Jun 21,2019 | Jul 22,2019 | Aug 02,2019 |         -11 |   16 |
                        +------+--------+------------+-------+-------+----------+--------+-------------+-------------+-------------+-------------+------+                
                    */
                    String okMsg = "Great, " + arrBkRet[1] + "[" + arrBkRet[0] + "] returned " + arrBkRet[5] + "[" + arrBkRet[3] + "]";
                    lblBkR_A_err.setText(okMsg);
                    lblBkR_A_err.setForeground(new Color(20, 140, 20));
                    pnlBk_R_C.setVisible(false);
                    pnlBk_R_B.setVisible(false);
                    pnlBk_R_A.setVisible(true);
                    showOnlyPanel("pnlBkRet");

                    // p("Retun Book subpnl1 Query 2 = \n"+sql);
                } else {
                    String cause = txtBkRet_C_2_reason.getText();
                    int nDaysIncOrDec = Integer.parseInt(txtBkRet_C_2_nDays.getText());
                    int sign = 1;
                    if (radioR_C_dec.isSelected())
                        sign = -1;
                    
                    nDaysIncOrDec *= sign;
                    //Select  date(sysdate()),date_add(date(sysdate()),interval 3 day);
                    /*
                        1? => nDaysIncOrDec
                        2? => cause
                        3? => nDaysIncOrDec
                        4? => tid
                    */
                    String sql = "";
                    //                    sql= "Update bktrans " +
                    //                                "Set m_actRetDt = Date_add(m_propDt , interval ? day)," +
                    //                                    "m_fine = null, " +
                    //                                    "m_delayCause = ?,"+
                    //                                    "m_nPropDt = ?"+
                    //                                "where t_id = ?;";
                    //							"OR" 
                    sql = "Update bktrans set m_actRetDt = Date_add( m_propDt , interval " + nDaysIncOrDec + " day),m_fine = null, m_delayCause = '" + cause + "', m_nPropDt = " + nDaysIncOrDec + " where t_id = " + tid;                
                    pstmt = con.prepareStatement(sql);
                    //                    pstmt.setInt(1,nDaysIncOrDec);
                    //                    pstmt.setString(2,cause);
                    //                    pstmt.setInt(3,nDaysIncOrDec);
                    //                    pstmt.setInt(4,tid);
                    if ((pstmt.executeUpdate()) == 0)
                        throw new Exception("OOPs... Could Not Save Information, Retry 2_1!");
                    
                    sql = "UPDATE tbl_books "
                            + "SET status = 'A' "
                            + "WHERE accid = ? AND accno = ?;";                
                    pstmt = null;
                    pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, accid);
                    pstmt.setInt(2, accno);
                    if ((pstmt.executeUpdate()) == 0)
                        throw new Exception("OOPs... Could Not Save Information, Retry 2_2!");
                    
                    String okMsg = "Great, " + arrBkRet[1] + "[" + arrBkRet[0] + "] returned " + arrBkRet[5] + "[" + arrBkRet[3] + "]";
                    lblBkR_A_err.setText(okMsg);
                    lblBkR_A_err.setForeground(new Color(20, 140, 20));
                    pnlBk_R_C.setVisible(false);
                    pnlBk_R_B.setVisible(false);
                    pnlBk_R_A.setVisible(true);
                    showOnlyPanel("pnlBkRet");
            }
        } catch (Exception e) {
            lblBkR_C_err.setForeground(new Color(250, 0, 0));
            showMsgOnLbl(e.getMessage(), lblBkR_C_err);
        }
    }
    public void resetReportComps() {

        if (checkRep_1.isSelected())
            checkRep_1.doClick();
        
        if (checkRep_2.isSelected())
            checkRep_2.doClick();
        
        checkRep_3.setSelected(false);
        checkRep_4.setSelected(false);

        comboRep1.setSelectedIndex(0);
        comboRep2.setSelectedIndex(0);
        comboRep3.setSelectedIndex(0);
        comboRep4.setSelectedIndex(0);

        repSub1.setBackground(new Color(240, 241, 240));
        lblRepDt.setText("  ");
        txtRepDD.setVisible(false);
        txtRepMM.setVisible(false);
        txtRepYYYY.setVisible(false);

        repSub2.setBackground(new Color(240, 241, 240));
        lblRepDt2.setText("  ");
        txtRepDD2.setVisible(false);
        txtRepMM2.setVisible(false);
        txtRepYYYY2.setVisible(false);

        reportErr.setForeground(new Color(255, 0, 0));
        if (isMemShipExpUpdated == -1 || isMemShipExpUpdated == -2) {
//      Membership Not Updated...            
            reportErr.setText("OOPs...Connection Failed, Re-Start MySql Database !");
            reportSubmit.setVisible(false);
            reportReset.setVisible(false);
        } else {
            reportErr.setText("");
            reportSubmit.setVisible(true);
            reportReset.setVisible(true);
        }
    }
    public String validateReportInfo(int selInd) {
		// Method to Validate Report Information...
		//  Check DateFields are proper or not : feb = min(28) max(29)
		//  Returns "ok" ==> if given Num of CheckBox's Rel.Fields are Valid ,==> else proper Err Msg
        if (selInd == 1) {    //  checkRep_1 isSelected
            String dd = txtRepDD.getText();
            String mm = txtRepMM.getText();
            String yyyy = txtRepYYYY.getText();
            int d, m, y;
            try {
                d = Integer.parseInt(dd);
                m = Integer.parseInt(mm);
                y = Integer.parseInt(yyyy);
            } catch (Exception e) {
                return "OOPs...Invalid Characters in Date Field, 0-9 digits Allowed !";
            }
            if (isValidDDMMYYYY(d, m, y) == false) 
                return "OOPs...Invalid Date Details entered in First Date !";
            
            if (comboRep1.getSelectedIndex() == 0) 
                return "OOPs...Criteria, for 1st Report query, is not Selected !";
            else
                return "ok";
        }
        if (selInd == 2) {    //  checkRep_2 isSelected
            String dd = txtRepDD2.getText();
            String mm = txtRepMM2.getText();
            String yyyy = txtRepYYYY2.getText();
            int d = 0, m = 0, y = 0;
            try {
                d = Integer.parseInt(dd);
                m = Integer.parseInt(mm);
                y = Integer.parseInt(yyyy);
            } catch (Exception e) {
                return "OOPs...Invalid Characters in Date Field,0-9 Allowed !";
            }
            if (isValidDDMMYYYY(d, m, y) == false) {
                return "OOPs...Invalid Date Details entered in Second Date !";
            }
            if (comboRep2.getSelectedIndex() == 0)
                return "OOPs...Criteria, for 2nd Report query, is not Selected !";
            else
                return "ok";
            
        } else {
            return "After if - NotOkay";
        }
    }
    public boolean isValidDDMMYYYY(int dd, int mm, int yyyy) {		
        /*  Method to validate Date in a DD_MM_YYYY Format
		Month Num : 1    2    3   4   5   6   7   8   9   10  11  12
        No of Day : 31 28/29 31  30  31   30  31  31  30  31  30  31
         */

        if ((yyyy < 2019))
            return false;
        
        if ((mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12)
                && (dd <= 31))
            return true;
        else if ((mm == 2) && (dd <= 29))
            return true;
        else if ((mm == 4 || mm == 6 || mm == 9 || mm == 11) && (dd <= 30)) 
            return true;
        else
            return false;
    }
    public String getOrderByForIndOfR3C1(int selIndRep3Combo1){
        //  Method to return SQL Statement i.e. "order by xyz"
        /*  Return 'Order by X,Y,Z' for 'selIndRep3Combo1' (B/w 1 to 7) selection of "Rep3Combo1"...
            Combo1_ Items :
                Select Criteria -  0
                Active Students -  1
                Active Teachers -  2
                Active Members  -  3
                Inactive Student-  4
                Inactive Teacher-  5
                Inactive Member -  6
                All Members     -  7
           Option in "comboRepSort3" -> 'Name' || 'Class' ||'Id'     */
            int selIndRep3Sort = comboRepSort3.getSelectedIndex();
            switch(selIndRep3Combo1){
                case 1:{        /*  'Active Students' Selected - Sort By 'Name' || 'Class' || 'Id' || 'LastSeen'
                                     +------+-------+------+------+------------+-----------+-----------+
                                     | M_id | Mname | cls  | rno  | mPh1       | mAddr     | LastSeen  |
                                     +------+-------+------+------+------------+-----------+-----------+
                                    Rep3_Combo1_1 : Sort By 'Name' || 'Class' || 'Id' || 'Last Seen'
                                */
                    if(selIndRep3Sort == 0)
                        return " order by Mname";
                    else if(selIndRep3Sort == 1)
                        return " order by cls,rno";
                    else if(selIndRep3Sort == 2)
                        return " order by m_id";
                    else
                        return " order by LastSeen Desc,cls";
                }
                case 2:{
            //  Rep3Combo 1_2 : Active Teachers - Sort By 'Name' || 'Class' || 'Id' || 'LastSeen'
            //    +------+-----------+------------+------------+-------------+-----------+
            //    | M_id | Mname     | mPh1       | Ph2        | mAddr       | LastSeen  |
            //    +------+-----------+------------+------------+-------------+-----------+
            //    | 1009 | Priyanshi | 8787878787 | 7676767676 | Bazaar      | 25 Jun,19 |
            //    | 1008 | shubh     | 9898989898 |   -        | bihar,patna | 19 Jul,19 |
            //    +------+-----------+------------+------------+-------------+-----------+
    
                    if( selIndRep3Sort == 0 )
                        return " order by Mname,LastSeen desc";
                    else if( selIndRep3Sort == 2 )
                        return " order by m_id";
                    else if( selIndRep3Sort == 3 )
                        return " order by LastSeen Desc,Mname";
                    else
                        return " order by Mname,rno";
                }
                case 3:{
            //    Rep3Combo 1_3 : 'Active Members'  - Sort By 'Name' || 'Class' ||'Id' || 'LastSeen'
            //    STUDENTs have (..., cls, rno, ... ) while 
            //    TEACHERs have ( .., ...)
            //    +------+-----------+------+------+------+------------+-------------+------------+
            //    | M_id | Mname     | cls  | rno  | Type | mPh1       | mAddr       | LastSeen   |
            //    +------+-----------+------+------+------+------------+-------------+------------+
            //    | 1004 | Jitu      | BCA  | 4    | Stu. | 9879879878 | Boharapur   | 2019-07-02 |
            //    | 1006 | Mina      | BCA  | 8    | Stu. | 9898989898 | Hinsaran    | 2019-07-15 |
            //    | 1007 | Rohit     | MBA  | 1    | Stu. | 9879879878 | Padri       | 2019-07-15 |
            //    | 1010 | Bhatt     | -    | -    | Fac. | 9879879878 | basharatpur | 2019-07-09 |
            //    | 1011 | Durgesh   | -    | -    | Fac. | 7676766666 | Nimsaran    | 2019-05-11 |
    
                    if( selIndRep3Sort == 0 )
                        return " order by mType, mName, cls";
                    else if( selIndRep3Sort == 1 )
                        return " order by mType, cls, rno";
                    else if( selIndRep3Sort == 2 )
                        return " order by mType,m_id";
                    else
                        return " order by mType,LastSeen desc,mName";
                }
                
               
                case 4:{
    //          Rep3combo1_4 : Inactive Students - Sort By 'Name' || 'Class' ||'Id' || 'LastSeen'
    //            +------+---------+--------+------+------------+------------+--------+------------+
    //            | M_id | Mname   | cls    | rno  | mPh1       | doj        | P.F.   | LastSeen   |
    //            +------+---------+--------+------+------------+------------+--------+------------+
                    if(selIndRep3Sort == 0)
                        return " order by Mname";
                    if(selIndRep3Sort == 1)
                        return " order by cls,rno";
                    else if(selIndRep3Sort == 2)
                        return " order by M_id";
                    else 
                        return " order by LastSeen Desc,Mname"; 
                }
                case 5:{
    //          Rep3combo1_5 : Inactive Teachers - Sort By 'Name' || 'Class' ||'Id' || 'LastSeen'
    //            +------+-------+------------+------------+------+------------+
    //            | M_id | Mname | mPh1       | doj        | P.F. | LastSeen   |
    //            +------+-------+------------+------------+------+------------+
                    if(selIndRep3Sort == 0)
                        return " order by Mname";
                    if(selIndRep3Sort == 3)
                        return " order by LastSeen Desc,Mname";
                    else if(selIndRep3Sort == 2)
                        return " order by M_id";
                    else 
                        return " order by cls,rno";
                }
                case 6:{
    //          combo1_6 : Inactive Member -  Sort By 'Name' || 'Class' ||'Id' || 'LastSeen'
    //            +------+---------+--------+------+------+------------+------------+------------+
    //            | M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
    //            +------+---------+--------+------+------+------------+------------+------------+
    
                    if(selIndRep3Sort == 0)
                        return " order by mType,Mname";
                    if(selIndRep3Sort == 1)
                        return " order by mType,cls,rno";
                    else if(selIndRep3Sort == 2)
                        return " order by mType,M_id";
                    else
                        return " order by mType, LastSeen desc, Mname";
                }
    
                case 7:{
    //          combo 7_ : All Members - Sort By 'Name' || 'Class' ||'Id' || 'LastSeen'
    //                    +------+---------+--------+------+------+------------+------------+-----------+
    //                    | M_id | Mname   | cls    | rno  | Type | Ph1        | doj        | LastSeen  |
    //                    +------+---------+--------+------+------+------------+------------+-----------+
                    if(selIndRep3Sort == 0)
                        return " order by mType,Mname,cls,rno";
                    if(selIndRep3Sort == 1)
                        return " order by mType,cls,rno";
                    if(selIndRep3Sort == 2)
                        return " order by mType,m_id";
                    else
                        return " order by mType,LastSeen desc";
                }
                default:{
                    return " order by mType,cls";
                }
            }        
        }
        public int check_UpdateExpiryOfMem_ship() {
            /* This method Checks and Updates Membership Expiry Status from 
               'A'ctive to 'I'nactive when 6 months past from Subscription
               i.e.: [System's Date ~ Date of Last Paid Protection Fee of Member >=180]
             */ int aff = 0;
            try {
                p("check_UpdateExpiryOfMem_ship() called...");
                Connection con = getDbConnObj();
                if (con == null)
                    throw new Exception("OOPs...Connection Error !");
                
                PreparedStatement st = null;
    
                /*  Steps to Debug :-
                
                -- This query Selects MemId and cals DaysFromLastProtFee from Table mems :-
                Select m_id,date(sysdate())Today,doPFee,(case
                        when (datediff(Date(sysdate()),doPFee)) >= 180
                        then ( abs(( 180 - datediff(Date(sysdate()),doPFee))))
                        else (0)
                        end)DaysFromLastProtFee
                from mems order by DaysFromLastProtFee;
    
                +------+------------+------------+---------------------+
                | m_id | Today      | doPFee     | DaysFromLastProtFee |
                +------+------------+------------+---------------------+
                | 1004 | 2020-07-04 | 2019-08-06 |                 153 |
                | 1006 | 2020-07-04 | 2019-07-15 |                 175 |
                | 1005 | 2020-07-04 | 2019-07-05 |                 185 |
                | 1003 | 2020-07-04 | 2019-07-01 |                 189 |
                +------+------------+------------+---------------------+
    
                -- This is a Final query Used in this Method to Selects 'm_Id' from Upper_Selected_Tabular_Structure temp :-
    
                select m_Id from (Select m_id,date(sysdate())Today,doPFee,(case
                        when (datediff(Date(sysdate()),doPFee)) >= 180
                        then ( abs(( 180 - datediff(Date(sysdate()),doPFee))))
                        else (0)
                        end)DaysFromLastProtFee
                    from mems order by DaysFromLastProtFee) temp
                where temp.DaysFromLastProtFee >=180;
                +------+
                | m_Id |
                +------+
                | 1005 |
                | 1003 |
                | .... |
                +------+    So These Member's Account will be set to 'I'nactive as they paid BookProtectionFee >= 180 days ago.             */
    
                String sql = "Update mems set mStatus = 'I' where m_id in ( "
                        + "Select m_Id from ( "
                        + "Select m_id,date(sysdate())Today,doPFee,(case "
                        + "when (datediff(Date(sysdate()),doPFee)) >= 180 "
                        + "then ( abs(( 180 - datediff(Date(sysdate()),doPFee)))) "
                        + "else (0) "
                        + "end)DaysFromLastProtFee "
                        + "from mems order by DaysFromLastProtFee) temp  "
                        + "where temp.DaysFromLastProtFee >=180 "
                        + ");";
                st = con.prepareStatement(sql);
                aff = st.executeUpdate();            
            } catch (SQLException se) {
                p("...SQLException se in check_UpdateExpiryOfMem_ship()\n e.getMessage() = " + se.getMessage());
                return -1;
            } catch (Exception e) {
                p("...Exception e in check_UpdateExpiryOfMem_ship()\n e.getMessage() = " + e.getMessage());
                return -2;
            }
            return aff;
        }

        public String getFileName_DateTimeName() {
            p("getFileName_DateTimeName() invoked...");
            Calendar cd = Calendar.getInstance();        
            String time = "" + cd.getTime();
            String reg = "([ ])";
            String[] arr = time.split(reg);
            time = arr[3];
            time = time.replace(":", "_");
            String filename = arr[1] + "_" + arr[2] + "_" + time + "_" + "Report.pdf";
            p(filename);
            //prints : "Dec_02_08_55_48_Report.pdf"
            return filename;
        }
        public String getReportTime(){
            p("getReportTime() invoked...");
            /*	Eg : Time = Wed Jul 17 01:04:30 PDT 2019
                Splitted : []arr = time.split(reg);
                arr[0] = Wed , arr[1] = Jul , arr[2] = 17 , arr[3] = 01:04:30 , arr[4] = PDT , arr[5] = 2019        
            */
            Calendar cd = Calendar.getInstance();
            String time = "" + cd.getTime();
            String reg = "([ ])";
            String[] arr = time.split(reg);        
            time = arr[3];
            time = time.replace(":", "_");
            String timeStamp = "" + arr[1] + " " + arr[2] + ", " + arr[5];
            return timeStamp;
        }
        public String getReportQueryFor(int selBox){
            // This method Returns ReportQuery for : 'selBox' JCheckboxNum and rel. 'comboboxes'...
            
                switch (selBox) {
                    p("\ngetReportQueryFor(int selBox) ... invoked");
                    case 0:                                  // Report's 1st CheckBox is Selected... 'List of All overdue Issued books'
                    {                                        //  ** Debug Query : select * from bktrans ;  -- Then see propDate and fill Fields of Form's 1st Report -:
                        String preFix, inFix, suFFix, sql="";
                        String dd = txtRepDD.getText();
                        String mm = txtRepMM.getText();
                        String yyyy = txtRepYYYY.getText();
                        
                        preFix = "Select c.b_name Book, m.mName Member, b.m_Id M_Id,"
                                + "m.cls 'Class', m.rno Rno,"
                                + "date_format(b.m_issDt,'%b %d,%y') IssuedOn, date_format(b.m_propDt, '%b %d,%y') LastDate,"
                                + "datediff(b.m_propDt,sysdate()) 'Left', m.mPh1 Phone  "
                                + "from bktrans b,mems m ,tbl_book_info c  ";
        
                        if (comboRep1.getSelectedIndex() == 1)		//  At Given Date... '='
                            inFix = " where b.m_propDt = '" + yyyy + "-" + mm + "-" + dd
                                    + "' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null ";
                        else//  After Given Date... '>'
                            inFix = " where b.m_propDt > '" + yyyy + "-" + mm + "-" + dd
                                    + "' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null ";
                        
                        suFFix = "";
                        if (comboRepSort1.getSelectedIndex() == 0)	//  Sort by Book name ...
                            suFFix = " order by m.mtype, c.b_name;";
                        
                        if (comboRepSort1.getSelectedIndex() == 1) 	//  Sort by Member name ...
                            suFFix = " order by m.mtype, m.mName,b.m_Id;";
                        
                        if (comboRepSort1.getSelectedIndex() == 2) 	//  Sort by Last Date ...
                            suFFix = " order by m.mtype, b.m_propDt, m.mName,b.m_Id;";
                        
                        sql = preFix + inFix + suFFix;
                        p("Report 1: 1_ ->" + sql);
                                                            //  sql = "Select c.b_name Book, b.b_acc_id B_id, m.mName Member, b.m_Id M_Id,(CASE WHEN m.mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', date_format(b.m_issDt,'%b %d,%y') IssuedOn, date_format(b.m_propDt, '%b %d,%y') LastDate, m.mPh1 Phone  from bktrans b,mems m ,tbl_book_info c  where b.m_propDt = '2019-08-02' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null  order by b.m_Id;";
                                                            //  inFix =  "where b.m_propDt = '2019-08-02' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null  order by m.mtype, b.m_Id;";
                                                            //  suFFix = " order by m.mtype, b.b_acc_id;";
                        return sql;
                    }
        
                    case 1:                                 // Report's 2nd CheckBox is Selected... 'List of Members whose MemShip Expires...'
                    {
                        // This Case will fetch and Return Query : Memberships_Expiry_Details :- For Reports 2nd CheckBoxSelection :
                        // ** Debug Query : select mname,doPFee ,(date_add(doPFee , interval 180 day)) Expiry from mems order by Expiry;
                        String prefix, infix, suffix, sql = "";
                        String dd = txtRepDD2.getText();
                        String mm = txtRepMM2.getText();
                        String yyyy = txtRepYYYY2.getText();
        
                        prefix = "Select m_id 'M.Id',mname 'Member', mPh1 'Contact No', (case when cls is null then '-' else cls end) 'Class',(case when rno is null then '-' else rno end) 'Rno',date_format(doPFee, '%b %d,%y') 'Last Paid',date_format(( Date_Add(doPFee, Interval 180 day)), '%b %d,%y') 'Expire On' ,datediff( Date_Add(doPFee, Interval 180 day),Date(sysdate())) 'Left' from mems  where  m_id in (select m_id ";
        
                        if (comboRep2.getSelectedIndex() == 1)       // At this Date
                            infix = "from (SELECT m_id, (case when (date_add( Inn.doPFee ,interval 180 day) = '" + yyyy + "-" + mm + "-" + dd + "') then 1 else 0 end ) isExpire from mems Inn ) temp where temp.isExpire = 1) ";
                        else
                            infix = "from (SELECT m_id, (case when (date_add( Inn.doPFee ,interval 180 day) < '" + yyyy + "-" + mm + "-" + dd + "') then 1 else 0 end ) isExpire from mems Inn ) temp where temp.isExpire = 1) ";
                        
                        if (comboRepSort2.getSelectedIndex() == 0) // Sort by Member 'mName'
                            suffix = "order by mname;";
                        else
                            suffix = "order by 'Left';";           // Sort by Days 'Left'
                        
                        sql = prefix + infix + suffix;
                        p("\nReport 2    :->" + sql);
                        return sql;
                    }
                    
                    case 2:                                        // Report's 3rd CheckBox is Selected... 'List of All Member...'
                    {
                        String prefix = "",infix = "",suffix = "",sql = "";
                        /*  ComboBox1_ Items :
                            Select Criteria -  0
                            Active Students -  1
                            Active Teachers -  2
                            Active Members  -  3
                            Inactive Student-  4
                            Inactive Teacher-  5
                            Inactive Member -  6                
                            All Members     -  7    */
                        int selIndCombo1 = comboRep3.getSelectedIndex();
                        if( selIndCombo1 == 1) {
        
                            
                            //p("\nSearching : - Active Students - 1 :- Select Only Active Students");
                            prefix= "Select  M_id, Mname, "+
                                        "(case when cls is null then '-' else cls end) cls, "+
                                        "(case when rno = 0 then '-' else rno end) rno, "+
                                         "mPh1, mAddr, "+
                                        "(CASE "+
                                            "When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) "+
                                            "THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) "+
                                            "WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL ) "+
                                            "THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1 )"+
                                            "ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) "+
                                        "END) LastSeen from mems m ";
                            infix = "Where mStatus = 'A' and mtype='S' ";
                            suffix = getOrderByForIndOfR3C1 (selIndCombo1);
                                        //   getOrderByForIndOfR3C1(_) Returns:- 'Sorting Criteria' A/c to Passed Selected Index of Report3_combo1:
                                        //   Which index of comboRepSort3 is select : Return proper 'Order by x,y,z'
                            sql = prefix + infix + suffix;
                            // p("\n-->Report Query : 3)\n\n"+sql);
                        }
                        else if(selIndCombo1 == 2) {
                        // Active Teachers -  2 :- Select Only Active Teachers
                            // p("\n\nsearching :- Active Teachers -  2 :- Select Only Active Teachers");
                            prefix= "Select  M_id, Mname,"+ 
                                        "mPh1,  "+
                                        "(case when mPh2 is null then '  -'  "+
                                                    "else mPh2  "+
                                            "end) Ph2,  "+
                                        "mAddr,  "+
                                        "(CASE  "+
                                                "When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )  "+
                                                "THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 )  "+
                                                "WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL )  "+
                                                "THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1)  "+
                                                "ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)  "+
                                        "END) LastSeen  "+
                                    "from mems m "+
                                    "where mtype='T' and mstatus = 'A' ";
                            suffix = getOrderByForIndOfR3C1( selIndCombo1 );         // checks which index of comboRepSort3 is select : then Return
                            sql = prefix + infix + suffix;
                            // p("\n-->Report Query : 3)\n\n"+sql);
                        }
                        else if(selIndCombo1 == 3) {
                        // Active Members -  3 :- Select Only Active Members
                            // p("\n\nSearching :- Active Members -  3 :- Select Only Active Members");
        
                            prefix= "Select  M_id, Mname, "+ 
                                        "(case when cls is null then '-' else cls end) cls, "+
                                        "(case when rno = 0 then '-' else rno end) rno, "+
                                        "(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', "+
                                         "mPh1, mAddr, "+
                                        "(CASE "+
                                                "When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )"+
                                                "THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) "+
                                                "WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) "+
                                                "THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) "+
                                                "ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) "+
                                        "END) LastSeen "+
                                    "from mems m "+
                                    "where mstatus = 'A' ";
                            suffix = getOrderByForIndOfR3C1(selIndCombo1);          // checks which index of comboRepSort3 is select : then Return
                            sql = prefix + infix + suffix;
                            // p("\n-->Report Query : 3)\n\n"+sql);
                        }
                        else if(selIndCombo1 == 4) {
                        // InActive Students -  4 :- Select Only InActive Students
        
                            // p("\n\nSearching :- InActive Students -  4 :- Select Only InActive Students");
                            prefix = "Select m.M_id, m.Mname, m.cls, m.rno, m.mPh1, m.doj, m.mProtectFee 'P.F.' , "+
                                            "(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) "+
                                            "	THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) "+
                                            "	WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) "+
                                            "	THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) "+
                                            "	ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) "+
                                            "END) LastSeen "+
                                    "from mems m "+
                                    "where mType='S' and mStatus='I' ";                    
                            suffix = getOrderByForIndOfR3C1(selIndCombo1);               // checks which index of comboRepSort3 is select : then Return
                            sql = prefix + infix + suffix;
                            // p("\n-->Report Query : 3)\n\n"+sql);
                        }
                        else if(selIndCombo1 == 5) {
                        // InActive Teachers -  5 :- Select Only InActive Teachers
                            // p("\n\n Searchig InActive Teachers -  5 :- Select Only InActive Teachers");
        
                            prefix = "Select m.M_id, m.Mname, m.mPh1, m.doj, m.mProtectFee 'P.F.' , "+
                                            "(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) "+
                                            "	THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) "+
                                            "	WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) "+
                                            "	THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) "+
                                            "	ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) "+
                                            "END) LastSeen "+
                                    "from mems m "+
                                    "where mType='T' and mStatus='I'";
                            suffix = getOrderByForIndOfR3C1(selIndCombo1);         // checks which index of comboRepSort3 is select : then Return
                            sql = prefix + infix + suffix;
                            // p("\n-->Report Query : 3)\n\n"+sql);
                        }
                        else if(selIndCombo1 == 6) {
                        // All InActive Members 6 :- Select All InActive Members
                            // p("\n\n Searching All InActive Members 6 :- Select All InActive Members");
        
                            prefix = "Select m.M_id, m.Mname, "+
                                            "(case when cls is null then '-' else cls end) cls, "+
                                            "(case when rno = 0 then '-' else rno end) rno, "+
                                            "(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', "+
                                            "m.mPh1, m.doj, "+
                                            "(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) "+
                                            "	THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) "+
                                            "	WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) "+
                                            "	THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1)  "+
                                            "	ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) "+
                                            "END) LastSeen "+
                                    "from mems m "+
                                    "where mStatus='I'";
                            suffix = getOrderByForIndOfR3C1(selIndCombo1);         // checks which index of comboRepSort3 is select : then Return
                            sql = prefix + infix + suffix;
                            // p("\n-->Report Query : 3)\n\n"+sql);
                        }
                        else{   // comboRep3.getSelectedIndex() == 7) {
        // All Members : 7 :- Selects All Members
                            // p("\n\n Searching := All Members : 6 :- Selects All Members");
        
                            prefix= "Select m.M_id, m.Mname, "+
                                        "(CASE when cls is null then '-' else cls end) cls, "+
                                        "(CASE when rno = 0 then '-' else rno end) rno, "+
                                        "(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', "+
                                        "m.mPh1 Ph1, "+
                                        "m.doj,	 "+
                                        "(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) "+
                                        "    THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 )  "+
                                        "    WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) "+
                                        "    THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1)  "+
                                        "    ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) "+
                                        "END) LastSeen "+
                                "FROM mems m";
                            suffix = getOrderByForIndOfR3C1( selIndCombo1 );         // checks which index of comboRepSort3 is select : then Return
                            sql = prefix + infix + suffix;
                            // p("\n-->Report Query : 3)\n\n"+sql);
                        }
                        return sql;
                    }
                    
                    case 3:                                // Report 4 was Checked...'List of All Books that Are...'
                    {
                        String prefix = "", infix = "", suffix = "", sql = "";
                        
                        int comboInd = comboRep4.getSelectedIndex();
                        int orderSelInd = comboRepSort4.getSelectedIndex();
                        
                        switch(comboInd)
                        {
                            case 1:    // that are 'Available'...
                            {   prefix= "Select a.b_Name Name, a.b_acc_id Code, a.b_qty Qty, a.b_auth1 'Author 1', a.b_auth2 'Author 2', a.b_price Price, a.b_rack Rack, "+
                                            "SUM(Case "+
                                                "When b.status='A' Then 1 "+
                                                "Else 0 "+
                                                "End "+
                                                ") as Available "+
                                       "From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid ";
                                infix = "Where b.status = 'A' Group By a.b_name, a.b_qty, a.b_acc_id ";
                        
                                // 0 - Sort By Date,
                                // 1 - Sort By Cost,
                                // 2 - Sort By Rack,
                                // 3 - By Book Id
                                /*  +-----------+-------+-----+----------+----------+--------+------+-----------+
                                    | Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | Available |
                                    +-----------+-------+-----+----------+----------+--------+------+-----------+    */
        
                                if(orderSelInd == 1)
                                    suffix = "Order by a.b_price desc, a.b_auth2";                        
                                else if(orderSelInd == 2)
                                    suffix = "Order by a.b_rack, a.b_auth2";
                                else if(orderSelInd == 3)
                                    suffix = "Order by a.b_acc_id, a.b_auth2";
                                else //if(orderSelInd == 0)
                                    suffix = "Order by a.b_Name";
        
                                sql = prefix + infix + suffix ;
                                p("\nReport 4: Combo 1 : 1st Selected...Sql = \n\n"+sql);
                                return sql;
                            }
        
                            case 2:    // that are 'Issued'...
                            {
                                prefix ="Select c.b_Name Name, b.b_acc_id BookCode, m.mName Member, b.m_id M_Id, "+
                                            "(CASE WHEN m.mType='S' "+
                                                "THEN (Select 'Stu.') "+
                                                "ELSE (Select 'Fac.')"+
                                                "END ) as 'Type', "+
                                            "date_format(b.m_issDt,'%b %d,%Y') issuedOn, "+
                                            "date_format( b.m_propDt,'%b %d,%Y' ) LastDate, "+
                                            "datediff( b.m_propDt , Date(Sysdate()) ) DaysLeft "+
                                        "From bktrans b, mems m ,tbl_book_info c  ";
                                infix = "where b.m_actRetDt is null and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id ";
                        
                                // 0 - Sort By Date,
                                // 1 - Sort By Cost,
                                // 2 - Sort By Rack,
                                // 3 - By Book Id
                                /*  +-----------+----------+---------+------+------+-------------+-------------+----------+
                                    | Name      | BookCode | Member  | Type | M_Id | issuedOn    | LastDate    | DaysLeft |
                                    +-----------+----------+---------+------+------+-------------+-------------+----------+    */
        
                                if(orderSelInd == 0)
                                    suffix = "Order by DaysLeft";
                                else if(orderSelInd == 3)
                                    suffix = "Order by c.b_acc_id, DaysLeft";
                                else //(orderSelInd == 1 || 2 )
                                    suffix = "Order by c.b_Name";
                                
                                sql = prefix + infix + suffix ;
                                p("\nReport 4: Combo 1 : 2nd Selected...Sql = \n\n"+sql);
                                return sql;
        
                            }
        
                            case 3:    // that are 'On Repairing'...
                            {
                                prefix ="Select a.b_Name Name, a.b_acc_id Code, a.b_qty Qty, a.b_auth1 'Author 1', a.b_auth2 'Author 2', a.b_price Price, a.b_rack Rack, "+
                                        "    SUM(case  "+
                                        "       when b.status='R' then 1 "+
                                        "       else 0 "+
                                        "       end "+
                                        "   ) as 'On Repair'  "+
                                        "From tbl_book_info a left join tbl_books b on a.b_acc_id=b.accid ";
                                infix = "Where b.status = 'R' "+
                                        "Group by a.b_name, a.b_qty, a.b_acc_id ";
                        
                                // 0 - Sort By Date,
                                // 1 - Sort By Cost,
                                // 2 - Sort By Rack,
                                // 3 - By Book Id
                                /*  +-----------+-------+-----+----------+----------+--------+------+-----------+
                                    | Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | On Repair |
                                    +-----------+-------+-----+----------+----------+--------+------+-----------+    */
        
                                if(orderSelInd == 1)
                                    suffix = "Order by a.b_price desc, a.b_qty desc";
                                else if(orderSelInd == 2)
                                    suffix = "Order by a.b_rack, a.b_qty desc";
                                else if(orderSelInd == 3)
                                    suffix = "Order by a.b_acc_id, a.b_qty desc";
                                else //if(orderSelInd == 0)
                                    suffix = "Order by a.b_Name ";
                                
                                sql = prefix + infix + suffix ;
                                // p("\nReport 4: Combo 1 : 3rd Selected...Sql = \n\n"+sql);
                                return sql;
                            }
        
                            case 4:    // that are 'Destroyed'...
                            {
                                prefix= "Select a.b_Name 'Name', "+
                                        "   a.b_acc_id 'Code', "+
                                        "   a.b_qty 'Qty', "+
                                        "   a.b_price 'Price', "+
                                        "   a.b_rack 'Rack', "+
                                        "   ( CASE  WHEN (d.m_id is Null ) THEN '  -' ELSE ( d.m_id ) END ) 'M_Id', "+
                                        "   d.delDate 'Date', "+
                                        "   ( CASE  WHEN (d.reason is Null ) THEN '  -'ELSE ( d.reason ) END ) 'Reason' "+
                                        "From tbl_book_info a, "+
                                        "   tbl_books b, "+
                                        "   mems m, "+
                                        "   bkdel d "+
                                        "Where d.accid = a.b_acc_id and d.accid = b.accid and d.accno = b.accno and (d.m_id = m.m_Id or (d.m_id is null)) ";
                                infix = "Group by b.accid, b.accno  ";
                        
                                // 0 - Sort By Date,
                                // 1 - Sort By Cost,
                                // 2 - Sort By Rack,
                                // 3 - By Book Id
                                
                                /*  +-----------+-------+-----+--------+------+------+------------+------------+
                                    | Name      | Code  | Qty | Price  | Rack | M_Id | Date       | Reason     |
                                    +-----------+-------+-----+--------+------+------+------------+------------+    */
        
                                if(orderSelInd == 0)
                                    suffix = "Order by d.delDate desc, d.reason";
                                if(orderSelInd == 1)
                                    suffix = "Order by a.b_price desc, d.reason";
                                else if(orderSelInd == 2)
                                    suffix = "Order by a.b_rack, d.reason";
                                else
                                    suffix = "Order by a.b_acc_id, d.reason";
                                
                                sql = prefix + infix + suffix ;
                                p("---> Report 4: Combo : 4th Selected, Sql = \n"+ sql);
                                return sql;
                            }
                            case 5:    // 'Select All Books'...
                            {
                                /*	What will the Query exactyly do...see below
                                "Set @counter := 0, @counterQty := 0, @counterAvb := 0, @counterIss := 0, @counterRep := 0 ,@counterDes := 0; "+
                                "Select * "+
                                "From (SELECT  "+
                                "        (Select (@counter := (@counter + 1) ) ) 'Sr.No.', "+
                                "        testt.BookName, "+
                                "        testt.BookQty, "+
                                "        testt.Code,  "+
                                "        testt.Available,  "+
                                "        testt.Issued,  "+
                                "        testt.Repair,  "+
                                "        testt.Destroyed, "+
                                "        (@counterQty := @counterQty + testt.BookQty ) TotalQty,	 "+
                                "        (@counterAvb := @counterAvb + testt.Available ) TotalAvb,  "+
                                "        (@counterIss := @counterIss + testt.Issued ) TotalIss,	 "+
                                "        (@counterRep := @counterRep + testt.Repair ) TotalRep,	 "+
                                "        (@counterDes := @counterDes + testt.Destroyed ) TotalDest  "+
                                "      From (Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code,  "+
                                "                SUM(case  when b.status='A' then 1 else 0 end) as Available,  "+
                                "                SUM(case  when b.status='I' then 1 else 0 end) as Issued,  "+
                                "                SUM(case  when b.status='R' then 1 else 0 end) as Repair,  "+
                                "                SUM(case  when b.status='D' then 1 else 0 end) as Destroyed "+ 
                                "           From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid  "+
                                "           GROUP BY a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id "+
                                "      )testt "+
                                " )Main; ";
                                                        Or 
                                In One line -: Select * From (SELECT          (Select (@counter := (@counter + 1) ) ) 'Sr.No.',         testt.BookName,         testt.BookQty,         testt.Code,          testt.Available,          testt.Issued,          testt.Repair,          testt.Destroyed,         (@counterQty := @counterQty + testt.BookQty ) TotalQty,         (@counterAvb := @counterAvb + testt.Available ) TotalAvb,         (@counterIss := @counterIss + testt.Issued ) TotalIss,         (@counterRep := @counterRep + testt.Repair ) TotalRep,         (@counterDes := @counterDes + testt.Destroyed ) TotalDest       From (Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code,                 SUM(case  when b.status='A' then 1 else 0 end) as Available,                 SUM(case  when b.status='I' then 1 else 0 end) as Issued,                 SUM(case  when b.status='R' then 1 else 0 end) as Repair,                 SUM(case  when b.status='D' then 1 else 0 end) as Destroyed            From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid            GROUP BY a.b_name, a.b_qty, a.b_acc_id       Order by a.b_name      )testt  )Main; 
                                But UnFortunately ^ this Long Query could not fetched by Java.ResultSet... So these Two Queries are used...
                                            
                                    "Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code, "+
                                    "	SUM(case  when b.status='A' then 1 else 0 end) as Available, "+
                                    "	SUM(case  when b.status='I' then 1 else 0 end) as Issued, "+
                                    "	SUM(case  when b.status='R' then 1 else 0 end) as Repair, "+
                                    "	SUM(case  when b.status='D' then 1 else 0 end) as Destroyed "+
                                    "From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid "+
                                    "GROUP BY a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ; "
        
                                    +--------------+---------+-------+-----------+--------+--------+-----------+
                                    | BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed |
                                    +--------------+---------+-------+-----------+--------+--------+-----------+
                                    | Java book    |       3 | 10001 |         1 |      0 |      0 |         2 |
                                    | Cpp Book     |       5 | 10002 |         3 |      1 |      0 |         1 |
                                    | Cpp 1.17     |       5 | 10003 |         3 |      1 |      0 |         1 |
                                    | Visual Basic |       4 | 10004 |         4 |      0 |      0 |         0 |
                                    +--------------+---------+-------+-----------+--------+--------+-----------+
                                    
                                    Query 2:
                                    SELECT (Select count(*) from tbl_book_info) TotalBooks,
                                        (Select count(*) from tbl_books) TotalQty,
                                        (Select count(*) from tbl_books where status='A') Available,
                                        (Select count(*) from tbl_books where status='I') Issued,
                                        (Select count(*) from tbl_books where status='R') Repair,
                                        (Select count(*) from tbl_books where status='D') Destroyed;
                                        
                                        +------------+----------+-----------+--------+--------+-----------+
                                        | TotalBooks | TotalQty | Available | Issued | Repair | Destroyed |
                                        +------------+----------+-----------+--------+--------+-----------+
                                        |          4 |       17 |        10 |      2 |      1 |         4 |
                                        +------------+----------+-----------+--------+--------+-----------+
                                */
                                //                        prefix= "Set @counter := 0, @counterQty := 0, @counterAvb := 0, @counterIss := 0, @counterRep := 0 ,@counterDes := 0; ";
                                //                        
                                //                        runReport4(prefix);     // Sets the Session Variables For the Report4Query5...
                                
                                prefix= "Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code, "+
                                        "   SUM(case  when b.status='A' then 1 else 0 end) as Available, "+
                                        "   SUM(case  when b.status='I' then 1 else 0 end) as Issued, "+
                                        "   SUM(case  when b.status='R' then 1 else 0 end) as Repair, "+
                                        "   SUM(case  when b.status='D' then 1 else 0 end) as Destroyed "+
                                        "From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid ";
                                
                                infix=  "GROUP BY a.b_name, a.b_qty, a.b_acc_id  ";
                                
                                if(orderSelInd==3)
                                     suffix = " Order by a.b_acc_id;";
                                else                  // OR
                                     suffix = " Order by a.b_name;";
        
                                // 0 - Sort By Date,
                                // 1 - Sort By Cost,
                                // 2 - Sort By Rack,
                                // 3 - By Book Id
                                
                                /*  +--------+--------------+---------+-------+-----------+--------+--------+-----------+----------+----------+----------+----------+-----------+
                                    | Sr.No. | BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed | TotalQty | TotalAvb | TotalIss | TotalRep | TotalDest |
                                    +--------+--------------+---------+-------+-----------+--------+--------+-----------+----------+----------+----------+----------+-----------+
                                    |      1 | Java book    |       3 | 10001 |         1 |      0 |      0 |         2 |        3 |        1 |        0 |        0 |         2 |   */
                                
                                sql = prefix + infix + suffix ;
                                p("---> Report 4: Combo : 5th Selected, Sql = \n"+ sql);
                                return sql;
                    }
                }
            }
        }
        return "";
    }
    public Document createReport(ResultSet rs, Document dc, int selReportCheckBox) {
        /*
            This method will Take Resultset According to -> which Report_CheckBox was Selected( Starts from 0 )...
            And Adds Fetched Table of Resultset into Given Document...  */
            p("\n Exe..ing creteReport( _,_,_ ) for i = " + selReportCheckBox);
            String msg = "";
            try {
                switch (selReportCheckBox) {
                    case 0:     // List of All issued books that are overdue [ 1) At this Date || 2) After this Date ] 
                        {
                        p("\nCase 0: Started");
                        
                        if (comboRep1.getSelectedIndex() == 1) // At this Date
                            msg = "List of All issued books that will overdue : At  " + txtRepDD.getText() + "-" + txtRepMM.getText() + "-" + txtRepYYYY.getText() + " :-";
                        else // After this Date
                            msg = "Details of All Issued Books that will Overdue : After  " + txtRepDD.getText() + "-" + txtRepMM.getText() + "-" + txtRepYYYY.getText() + " :-";
    
                        //  Setting Report's Heading in PDF :-
                        dc.add(new Paragraph(" "));
                        dc.add(new Paragraph(msg));
                        String borderBtm = "";
                        for (int i = 0; i <= (msg.length() - 16); i++)
                            borderBtm += "_";                    
                        dc.add(new Paragraph(borderBtm));
                        dc.add(new Paragraph(" "));
    
                        /*      Setting Tabular Information of This Report Query :-
                                Fields in ResultSet : 9
                                +-----------+--------+------+--------+------+-----------+-----------+------+------------+
                                | Book      | Member | M_Id | Class  | Rno  | IssuedOn  | LastDate  | Left | Phone      |
                                +-----------+--------+------+--------+------+-----------+-----------+------+------------+       */
    
                        PdfPTable table = new PdfPTable(9);
                        PdfPCell[] cells = null;
                        cells = new PdfPCell[9];
                        {
                            PdfPCell c1 = new PdfPCell(new Phrase("Book"));
                            cells[0] = c1;
    
                            c1 = new PdfPCell(new Phrase("Member"));
                            cells[1] = c1;
    
                            c1 = new PdfPCell(new Phrase("M_Id"));
                            cells[2] = c1;
    
                            c1 = new PdfPCell(new Phrase("Class"));
                            cells[3] = c1;
    
                            c1 = new PdfPCell(new Phrase("Rno"));
                            cells[4] = c1;
    
                            c1 = new PdfPCell(new Phrase("Issued On"));
                            cells[5] = c1;
    
                            c1 = new PdfPCell(new Phrase("Last Date"));
                            cells[6] = c1;
    
                            c1 = new PdfPCell(new Phrase("Left"));
                            cells[7] = c1;
    
                            c1 = new PdfPCell(new Phrase("Phone"));
                            cells[8] = c1;
    
                        }
    
                        for (int i = 0; i < cells.length; i++) {
                            PdfPCell c = cells[i];
                            c.setBackgroundColor(BaseColor.GREEN);
                            c.setPaddingTop(5.0f);
                            c.setPaddingLeft(6.0f);
                            c.setPaddingBottom(5.0f);
                            c.setPaddingLeft(6.0f);
                            if (i == 1) {
                                c.setPaddingLeft(2.0f);
                                c.setPaddingRight(0.0f);
                            }
                            if (i == 2 || i == 4 || i == 7)
                                c.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
                            
                            table.addCell(c);
                        }
                        table.setHeaderRows(1);
                        //  Setting Data below to Header :-
                        int rowNum = 0;
                        while (rs.next()) {
    
                            PdfPCell c1 = new PdfPCell(new Phrase("" + rs.getString(1)));
                            c1.setPaddingLeft(2.0f);c1.setPaddingRight(1.0f);
                            cells[0] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                            c1.setPaddingLeft(2.0f);c1.setPaddingRight(1.0f);
                            cells[1] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getInt(3)));
                            c1.setPaddingLeft(6.0f);
                            cells[2] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getString(4)));
                            c1.setPaddingLeft(5.0f);
                            cells[3] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getInt(5)));
                            if (("" + rs.getInt(5)).length() < 5) 
                                c1.setPaddingLeft(13.0f);
                            else         
                                c1.setPaddingLeft(5.0f);
                            cells[4] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getString(6)));
                            c1.setPaddingLeft(6.0f);
                            cells[5] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getString(7)));
                            c1.setPaddingLeft(6.0f);
                            cells[6] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getInt(8)));
                            c1.setPaddingLeft(10.0f);
                            cells[7] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getLong(9)));
                            c1.setPaddingLeft(4.0f);c1.setPaddingRight(3.0f);
                            cells[8] = c1;
    
                            rowNum++;
                            if ((rowNum % 2) == 0) {
                                for (int i = 0; i < cells.length; i++) {
                                    cells[i].setPaddingTop(4.0f);
                                    cells[i].setPaddingBottom(5.0f);
                                    cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);            
                                    table.addCell(cells[i]);
                                }
                            } else {
                                for (int i = 0; i < cells.length; i++) {
                                    cells[i].setPaddingTop(4.0f);
                                    cells[i].setPaddingBottom(5.0f);
                                    table.addCell(cells[i]);
                                }
                            }
                        }
                        dc.add(table);
                        dc.add(new Paragraph(" "));
                        msg = "               :) Total Records Founds : "+rowNum;
                        dc.add(new Paragraph(msg));
                        dc.add(new Paragraph(" "));
                        break;
                    }
                    
                    case 1:     // List of Members whose Membership Expires [ 1) At Given Date  2) Before a Date ]
                    {
                        if (comboRep1.getSelectedIndex() == 1)
                            msg = "Details of Members whose Membership's Expiry Date is  " + txtRepDD2.getText() + "-" + txtRepMM2.getText() + "-" + txtRepYYYY2.getText();
                        else
                            msg = "Details of Members whose Membership's Expiry Date Before  " + txtRepDD2.getText() + "-" + txtRepMM2.getText() + "-" + txtRepYYYY2.getText()+" are";
    
                        dc.add(new Paragraph(" "));
                        dc.add(new Paragraph(" "));
                        //  Setting Report's Heading in PDF :- 
                        Paragraph para = new Paragraph(msg);
                        dc.add(new Paragraph(msg));
                        String borderBtm = "";
                        for (int i = 0; i <= (msg.length() - 10); i++) 
                            borderBtm += "_";
                        
                        dc.add(new Paragraph(borderBtm));
                        dc.add(new Paragraph(" "));
                        /*  Setting Tabular Information of This Report Query 2:-
                            Fields in ResultSet : 8
                            +------+---------+------------+--------+------+-----------+-----------+------+
                            | M.Id | Member  | Contact No | Class  | Rno  | Last Paid | Expire On | Left |
                            +------+---------+------------+--------+------+-----------+-----------+------+    
                            | 1001 | Shubham | 8601725056 | BCA    | 1    | Jun 29,19 | Dec 26,19 |  161 |
                            +------+---------+------------+--------+------+-----------+-----------+------+
                        */
                        PdfPTable table = new PdfPTable(8);
                        PdfPCell[] cells = null;
                        cells = new PdfPCell[8];
                        {
                            PdfPCell c1 = new PdfPCell(new Phrase("Id"));
                            c1.setPaddingLeft(20.0f);
                            cells[0] = c1;
                            c1 = new PdfPCell(new Phrase("Member"));
                            c1.setPaddingLeft(5.0f);
                            cells[1] = c1;
                            c1 = new PdfPCell(new Phrase("Ph.No."));
                            c1.setPaddingLeft(8.0f);
                            cells[2] = c1;
                            c1 = new PdfPCell(new Phrase("Class"));
                            c1.setPaddingLeft(8.0f);
                            cells[3] = c1;
                            c1 = new PdfPCell(new Phrase("Roll No"));
                            c1.setPaddingLeft(6.0f);
                            cells[4] = c1;
                            c1 = new PdfPCell(new Phrase("Last Paid"));
                            c1.setPaddingLeft(0.0f);
                            cells[5] = c1;
                            c1 = new PdfPCell(new Phrase("Expire"));
                            c1.setPaddingLeft(8.0f);
                            cells[6] = c1;
                            c1 = new PdfPCell(new Phrase("Left"));
                            c1.setPaddingLeft(13.0f);
                            cells[7] = c1;
                        }
                        for (int i = 0; i < cells.length; i++) {
                            cells[i].setBackgroundColor(BaseColor.GREEN);
                            cells[i].setPaddingTop(10.0f);
                            cells[i].setPaddingBottom(10.0f);
                            cells[i].setPaddingRight(2.0f);
                            table.addCell(cells[i]);
                        }
                        table.setHeaderRows(1);
    
                        int rowNum = 0;
                        while (rs.next()) {
    
                            PdfPCell c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                            c1.setPaddingLeft(10.0f);
                            cells[0] = c1;
    
                            c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                            c1.setPaddingLeft(2.0f);
                            c1.setPaddingRight(1.0f);
                            cells[1] = c1;
                            c1 = new PdfPCell(new Phrase("" + rs.getLong(3)));
                            c1.setPaddingLeft(4.0f);
                            c1.setPaddingRight(3.0f);
                            cells[2] = c1;
                            c1 = new PdfPCell(new Phrase("" + rs.getString(4)));
                            c1.setPaddingLeft(7.0f);
                            cells[3] = c1;
                            c1 = new PdfPCell(new Phrase("" + rs.getInt(5)));
                            if (("" + rs.getInt(5)).length() < 5) {
                                c1.setPaddingLeft(15.0f);
                            } else {
                                c1.setPaddingLeft(5.0f);
                            }
                            cells[4] = c1;
                            c1 = new PdfPCell(new Phrase("" + rs.getString(6)));
                            c1.setPaddingLeft(10.0f);
                            c1.setPaddingRight(5.0f);
                            cells[5] = c1;
                            c1 = new PdfPCell(new Phrase("" + rs.getString(7)));
                            c1.setPaddingLeft(10.0f);
                            c1.setPaddingRight(5.0f);
                            cells[6] = c1;
                            c1 = new PdfPCell(new Phrase("" + rs.getInt(8)));
                            c1.setPaddingLeft(13.0f);
                            cells[7] = c1;
    
                            rowNum++;
                            if ((rowNum % 2) == 0) {
                                for (int i = 0; i < cells.length; i++) {
                                    cells[i].setPaddingTop(4.0f);
                                    cells[i].setPaddingBottom(5.0f);
                                    cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);            
                                    table.addCell(cells[i]);
                                }
                            } else {
                                for (int i = 0; i < cells.length; i++) {
                                    cells[i].setPaddingTop(6.0f);
                                    cells[i].setPaddingBottom(7.0f);
                                    table.addCell(cells[i]);
                                }
                            }
                        }
                        dc.add(table);
                        dc.add(new Paragraph(" "));
                        msg = "               :) Total Records Founds : "+rowNum;
                        dc.add(new Paragraph(msg));
                        dc.add(new Paragraph(" "));
                        break;
                    }
                    
                    case 2: 
                    {                    
                        int selInd = comboRep3.getSelectedIndex();
                        
                        if(selInd == 1){                    
                            msg = "Details of All active Students :-";
                            dc = setReport3InTable(dc,rs,1);
                        }
                        else if(selInd == 2){                        
                            msg = "Details of All active Teachers :-";
                            dc = setReport3InTable(dc,rs,2);
                        }
                        else if(selInd == 3){                        
                            msg = "Details of All active Members :-";
                            dc = setReport3InTable(dc,rs,3);
                        }
                        else if(selInd == 4){
                            msg = "Details of All Inactive Students :-";
                            dc = setReport3InTable(dc,rs,4);
                        }
                        else if(selInd == 5){
                            msg = "Details of All Inactive Teachers :-";
                            dc = setReport3InTable(dc,rs,5);
                        }
                        else if(selInd == 6){
                            msg = "Details of All Inactive Members :-";
                            dc = setReport3InTable(dc,rs,6);
                        }
                        else {//(selInd == 7)
                            msg = "Details of All Members of the Library :-";
                            dc = setReport3InTable(dc,rs,7);
                        }
                        break;
                    }
                    
                    
                    case 3: // Report 4 : All Books....
                    {
                        int selInd = comboRep4.getSelectedIndex();
                        
                        if(selInd == 1){
                            msg = "Details of All active Students :-";
                            dc = setReport4InTable(dc,rs,1);
                        }
                        else if(selInd == 2){
                            msg = "Details of All active Teachers :-";
                            dc = setReport4InTable(dc,rs,2);
                        }
                        else if(selInd == 3){                        
                            msg = "Details of All active Members :-";
                            dc = setReport4InTable(dc,rs,3);
                        }
                        else if(selInd == 4){
                            msg = "Details of All Inactive Students :-";
                            dc = setReport4InTable(dc,rs,4);
                        }
                        else {//(selInd == 5)
                            msg = "Details of All Inactive Teachers :-";
                            dc = setReport4InTable(dc,rs,5);
                        }
                        break;
                    }
                    default: {
    
                    }
                }
        } catch (Exception e){
            msg = "----------- Some Information could not print Properly, Retry -----------";
            try {
                dc.add(new Paragraph(msg));
            } catch (Exception ee) {
            }
            p("\nException in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());
        }
        return dc;
    }
    public Document setReport3InTable(Document dc, ResultSet rs, int selInd){ // public Document createReport(ResultSet rs, Document dc, int selCheckBox) 
        p("\nDocument setReport3InTable( , , ) invoked...");
		String msg = "";
        try{
            switch(selInd){
                
                case 1:{ // Report3_Combo1 : 1) Active Student Selected
					//  Setting Report's Heading in PDF :-                        
                    msg = "Details of All Active Students :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 10); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));

					/*  +------+-------+------+------+------------+-----------+-----------+
						| M_id | Mname | cls  | rno  | mPh1       | mAddr     | LastSeen  |
						+------+-------+------+------+------------+-----------+-----------+
						| 1004 | Jitu  | BCA  | 4    | 9879879878 | Boharapur | 2019-01-01|     */
                    
                    PdfPTable table = new PdfPTable(7);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[7];
                    
                    PdfPCell c1 = new PdfPCell(new Phrase("      Id"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("   Name"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("   Class"));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("     Rno"));
                    cells[3] = c1;    

                    c1 = new PdfPCell(new Phrase("Phone No"));
                    cells[4] = c1;    

                    c1 = new PdfPCell(new Phrase(" Address"));
                    cells[5] = c1;    

                    c1 = new PdfPCell(new Phrase("Last Seen"));
                    cells[6] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(8.0f);
                        
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);     //p("\ntable.getTotalHeight() ==> "+table.getTotalHeight());
                    c1 = null;
                    
					/*      +------+-------+------+------+------------+-----------+-----------+
							| M_id | Mname | cls  | rno  | mPh1       | mAddr     | LastSeen  |
							+------+-------+------+------+------------+-----------+-----------+
							| 1004 | Jitu  | BCA  | 4    | 9879879878 | Boharapur | 2019-01-01|         */

                    int rowNum = 0;
                    while(rs.next()){                        
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                        c1.setPaddingLeft(13.0f);
                        cells[0] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[1] = c1;
                        c1 = new PdfPCell(new Phrase("" + rs.getString(3)));
                        c1.setPaddingLeft(8.0f);
                        c1.setPaddingRight(2.0f);
                        cells[2] = c1;                        
                        c1 = new PdfPCell(new Phrase("" + rs.getLong(4)));
                        if( (""+rs.getLong(4)).length() < 6 )
                            c1.setPaddingLeft(18.0f);
                        else{
                            c1.setPaddingLeft(2.0f);
                            c1.setPaddingRight(1.0f);
                        }
                        cells[3] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getLong(5)));
                        c1.setPaddingLeft(4.0f);
                        c1.setPaddingRight(4.0f);
                        cells[4] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(6)));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[5] = c1;
                        
                        String formattedDate = getDateAsMonDateYear(rs.getString(7));   // Takes as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[6] = c1;
                        
                        rowNum++;
                        if((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);            
                                table.addCell(cells[i]);
                            }
                        else 
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                    }
                    dc.add(table);
                    dc.add(new Paragraph(" "));
                    msg = "               :) Total Records Founds : "+rowNum;
                    dc.add(new Paragraph(msg));
                    dc.add(new Paragraph(" "));
                    p("\nReport 3 : Combo 1 :- Case 1: Ended");
                    break;
                }
                case 2:{
				/*      +------+-----------+------------+------------+-------------+------------+
						| M_id | Mname     | mPh1       | Ph2        | mAddr       | LastSeen   |
						+------+-----------+------------+------------+-------------+------------+
						| 1010 | Bhatt     | 9879879878 |   -        | basharatpur | 2019-07-09 |
						| 1011 | Durgesh   | 7676766666 | 6767676767 | Nimsaran    | 2019-05-11 |       */
                    
                    msg = "Details of All Active Teachers :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 10); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));
                    
                    PdfPTable table = new PdfPTable(6);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[6];
                    
                    PdfPCell c1 = new PdfPCell(new Phrase("       Id"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("    Name"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("   Ph.No.1"));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("   Ph.No.2"));
                    cells[3] = c1;    

                    c1 = new PdfPCell(new Phrase("   Address"));
                    cells[4] = c1;

                    c1 = new PdfPCell(new Phrase("  Last Seen"));
                    cells[5] = c1;

                    for (int i = 0; i < cells.length; i++){
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);     //p("\ntable.getTotalHeight() ==> "+table.getTotalHeight());

                    c1 = null;

                    int rowNum = 0;
					/*      +------+-----------+------------+------------+-------------+------------+
							| M_id | Mname     | mPh1       | Ph2        | mAddr       | LastSeen   |
							+------+-----------+------------+------------+-------------+------------+
							| 1010 | Bhatt     | 9879879878 |   -        | basharatpur | 2019-07-09 |
							| 1011 | Durgesh   | 7676766666 | 6767676767 | Nimsaran    | 2019-05-11 |       */
                    
                    while(rs.next()){                        
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                        c1.setPaddingLeft(13.0f);
                        cells[0] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[1] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getLong(3)));
                        c1.setPaddingLeft(11.0f);
                        c1.setPaddingRight(6.0f);
                        cells[2] = c1;
                        
                        String phone2 = "" ;                        
                        try{
                            long ph2 = rs.getLong(4);
                            phone2 = "" + ph2;        // Ph2 may have 2 types of Data : 1) 9898988787 , 2) "   -"
                        }catch(Exception e){
                            phone2 = "     -";
                                                      // p("@@@ Nominal Exception in Rep3Combo2 : e.getMessage() = " + e.getMessage());
                        }

                        c1 = new PdfPCell(new Phrase("" + phone2));
                        c1.setPaddingLeft(11.0f);
                        c1.setPaddingRight(6.0f);
                        cells[3] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(5)));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[4] = c1;
					/*      +------+-----------+------------+------------+-------------+------------+
							| M_id | Mname     | mPh1       | Ph2        | mAddr       | LastSeen   |
							+------+-----------+------------+------------+-------------+------------+
							| 1010 | Bhatt     | 9879879878 |   -        | basharatpur | 2019-07-09 |
							| 1011 | Durgesh   | 7676766666 | 6767676767 | Nimsaran    | 2019-05-11 |       */
                        
                        String formattedDate = getDateAsMonDateYear(rs.getString(6));   // Takes as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(4.0f);
                        c1.setPaddingRight(2.0f);
                        cells[5] = c1;
                        
                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);            
                                table.addCell(cells[i]);
                            }
                        else
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                    }
                    dc.add(table);
                    dc.add(new Paragraph(" "));
                    msg = "               :) Total Records Founds : "+rowNum;
                    dc.add(new Paragraph(msg));
                    dc.add(new Paragraph(" "));
                    break;
                }
                case 3:{
					//    +------+-----------+------+------+------+------------+-------------+------------+
					//    | M_id | Mname     | cls  | rno  | Type | mPh1       | mAddr       | LastSeen   |
					//    +------+-----------+------+------+------+------------+-------------+------------+
					//    | 1004 | Jitu      | BCA  | 4    | Stu. | 9879879878 | Boharapur   | 2019-07-02 |
					//    | 1010 | Bhatt     | -    | -    | Fac. | 9879879878 | basharatpur | 2019-07-09 |
        
                    msg = "Details of All Active Members :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 10); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));

                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];
                    

                    PdfPCell c1 = new PdfPCell(new Phrase("     Id"));                    
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("  Name"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("  Class"));
                    cells[2] = c1;
                    
                    c1 = new PdfPCell(new Phrase("  Rno"));
                    cells[3] = c1;    

                    c1 = new PdfPCell(new Phrase("  Type"));
                    cells[4] = c1;
					//    +------+-----------+------+------+------+------------+-------------+------------+
					//    | M_id | Mname     | cls  | rno  | Type | mPh1       | mAddr       | LastSeen   |
					//    +------+-----------+------+------+------+------------+-------------+------------+
					//    | 1004 | Jitu      | BCA  | 4    | Stu. | 9879879878 | Boharapur   | 2019-07-02 |
					//    | 1010 | Bhatt     | -    | -    | Fac. | 9879879878 | basharatpur | 2019-07-09 |

                    c1 = new PdfPCell(new Phrase("  Ph.No."));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase("Address"));
                    c1.setPaddingLeft(1.0f);
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase("LastSeen"));
                    c1.setPaddingLeft(0.0f);
                    c1.setPaddingRight(0.0f);
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }
                    table.setHeaderRows(1);
                    c1 = null;
                    
                    int rowNum = 0;

                    while(rs.next()){
					//    +------+-----------+------+------+------+------------+-------------+------------+
					//    | M_id | Mname     | cls  | rno  | Type | mPh1       | mAddr       | LastSeen   |
					//    +------+-----------+------+------+------+------------+-------------+------------+
					//    | 1004 | Jitu      | BCA  | 4    | Stu. | 9879879878 | Boharapur   | 2019-07-02 |
					//    | 1010 | Bhatt     | -    | -    | Fac. | 9879879878 | basharatpur | 2019-07-09 |
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                        c1.setPaddingLeft(8.0f);
                        cells[0] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;
						// p("___Rep3Com1_Sel : "+selInd+", Mname saved");
                        
                        String memberClass;
                        String memberRno;
                        
                        if(rs.getString(5).equals("Stu.")){                 // if 'Type' = 'Stu.' then Store those 'Class' and 'Rno' value else Store '   -' in Table Cell...
                            memberClass = rs.getString(3);
                            memberRno = "" + rs.getLong(4);
                        }else{
                            memberClass = "  -";
                            memberRno = "  -";
                        }
                        c1 = new PdfPCell(new Phrase("" + memberClass));                        
                        c1.setPaddingLeft(5.0f);                        
                        cells[2] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + memberRno));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[3] = c1;
                        
                        if( (memberRno.length()) < 6 )
                            c1.setPaddingLeft(15.0f);
                        else
                            c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getString(5)));
                        c1.setPaddingLeft(11.0f);
                        c1.setPaddingRight(2.0f);
                        cells[4] = c1;

						/*      +------+-----------+------+------+------+------------+-------------+------------+
								| M_id | Mname     | cls  | rno  | Type | mPh1       | mAddr       | LastSeen   |
								+------+-----------+------+------+------+------------+-------------+------------+       
							rs =    1       2         3      4      5       6            7             8                 */
                                                                        
                        c1 = new PdfPCell(new Phrase("" + rs.getLong(6)));
                        c1.setPaddingLeft(6.0f);
                        c1.setPaddingRight(6.0f);
                        cells[5] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(7)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[6] = c1;

                        String formattedDate = getDateAsMonDateYear(rs.getString(8));   // Takes as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(10.0f);

                        cells[7] = c1;
                        
                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else 
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                    }
                    dc.add(table);
                    dc.add(new Paragraph(" "));
                    msg = "               :) Total Records Founds : "+rowNum;
                    dc.add(new Paragraph(msg));
                    dc.add(new Paragraph(" "));
                    // p("\nReport 3 : Combo 1 :- Case 3: Ended");                    
                    break;
                }
                case 4:{
                    // p("--->Report 3: Combo1 :-> 4 index selected");
                    
                    msg = "Details of All Inactive Students :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 10); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));

					/*      +------+---------+--------+------+------------+------------+--------+------------+
							| M_id | Mname   | cls    | rno  | mPh1       | doj        | P.F.   | LastSeen   |
							+------+---------+--------+------+------------+------------+--------+------------+
							| 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 500.00 | 2019-08-05 |
							| 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 500.00 | 2019-07-31 |
							| 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 500.00 | 2019-07-05 |
							+------+---------+--------+------+------------+------------+--------+------------+      */
                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];
                    
                    PdfPCell c1 = new PdfPCell(new Phrase("     Id"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("  Name"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("   Class"));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("   Rno"));
                    cells[3] = c1;    

                    c1 = new PdfPCell(new Phrase(" Ph. No."));
                    cells[4] = c1;

                    c1 = new PdfPCell(new Phrase(" Joined"));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase("Prot.Fee"));
                    c1.setPaddingLeft(1.0f);
                    c1.setPaddingLeft(1.0f);
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase("Lastseen"));
                    c1.setPaddingLeft(0.0f);
                    c1.setPaddingLeft(0.0f);
                    cells[7] = c1;

					/*      +------+---------+--------+------+------------+------------+--------+------------+
							| M_id | Mname   | cls    | rno  | mPh1       | doj        | P.F.   | LastSeen   |
							+------+---------+--------+------+------------+------------+--------+------------+      */

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);
                    c1 = null;
                    
                    int rowNum = 0;

                    while(rs.next()){
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                        c1.setPaddingLeft(8.0f);
                        cells[0] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(3)));
                        c1.setPaddingLeft(4.0f);
                        c1.setPaddingRight(2.0f);
                        cells[2] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getLong(4)));
                        if( (""+rs.getLong(4)).length() < 6 )
                            c1.setPaddingLeft(15.0f);
                        else
                            c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);                        
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getLong(5)));
                        c1.setPaddingLeft(4.0f);
                        c1.setPaddingRight(3.0f);
                        cells[4] = c1;
                                                                        
                        String formattedDate = getDateAsMonDateYear(rs.getString(6));   // Takes as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(7.0f);
                        c1.setPaddingRight(0.0f);
                        cells[5] = c1;
						/*      +------+---------+--------+------+------------+------------+--------+------------+
								| M_id | Mname   | cls    | rno  | mPh1       | doj        | P.F.   | LastSeen   |
								+------+---------+--------+------+------------+------------+--------+------------+       */
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getDouble(7)));
                        c1.setPaddingLeft(8.0f);                        
                        cells[6] = c1;

                        formattedDate = getDateAsMonDateYear(rs.getString(8));   // Takes as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(7.0f);
                        c1.setPaddingRight(0.0f);
                        cells[7] = c1;
                        
                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++){
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else 
                            for (int i = 0; i < cells.length; i++){
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                    }
                    dc.add(table);
                    dc.add(new Paragraph(" "));
                    msg = "               :) Total Records Founds : "+rowNum;
                    dc.add(new Paragraph(msg));
                    dc.add(new Paragraph(" "));
                    p("\nReport 3 : Combo 1 :- Case 4: Ended");
                    break;                
                }
                case 5:{
                    // p("--->Report 3: Combo1 :-> 5 index selected");
                    
                    msg = "Details of All InActive Teachers :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 10); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));
					/*      +------+-------+------------+------------+------+------------+
							| M_id | Mname | mPh1       | doj        | P.F. | LastSeen   |
							+------+-------+------------+------------+------+------------+
							| 1002 | Satya | 8787878787 | 2019-06-29 | 0.00 | 2019-07-31 |
							+------+-------+------------+------------+------+------------+      */
                    PdfPTable table = new PdfPTable(6);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[6];
                    
                    PdfPCell c1 = new PdfPCell(new Phrase("      Id"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("    Name"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase(" Phone No."));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("  Joined on"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("  Prot. Fee"));
                    cells[4] = c1;

                    c1 = new PdfPCell(new Phrase(" Last Seen"));
                    c1.setPaddingLeft(2.0f);
                    cells[5] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);
                    c1 = null;
                    
                    int rowNum = 0;

                    while(rs.next()){
					/*      +------+-------+------------+------------+------+------------+
							| M_id | Mname | mPh1       | doj        | P.F. | LastSeen   |
							+------+-------+------------+------------+------+------------+
							| 1002 | Satya | 8787878787 | 2019-06-29 | 0.00 | 2019-07-31 |
							+------+-------+------------+------------+------+------------+      */

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                        c1.setPaddingLeft(12.0f);
                        cells[0] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getLong(3)));
                        c1.setPaddingLeft(6.0f);
                        c1.setPaddingRight(6.0f);
                        cells[2] = c1;
                        
                        String formattedDate = getDateAsMonDateYear(rs.getString(4));   // Takes as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(7.0f);                        
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getDouble(5)));
                        c1.setPaddingLeft(14.0f);
                        c1.setPaddingRight(2.0f);
                        cells[4] = c1;

                        formattedDate = getDateAsMonDateYear(rs.getString(6));         // Takes as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(6.0f);
                        c1.setPaddingRight(1.0f);
                        cells[5] = c1;
						/*      +------+-------+------------+------------+------+------------+
								| M_id | Mname | mPh1       | doj        | P.F. | LastSeen   |
								+------+-------+------------+------------+------+------------+
								| 1002 | Satya | 8787878787 | 2019-06-29 | 0.00 | 2019-07-31 |
								+------+-------+------------+------------+------+------------+      */
                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else 
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                    }
                    dc.add(table);
                    dc.add(new Paragraph(" "));
                    msg = "               :) Total Records Founds : "+rowNum;
                    dc.add(new Paragraph(msg));
                    dc.add(new Paragraph(" "));
                    // p("\nReport 3 : Combo 1 :- Case 5: Ended");
                    break;
                
                }
                case 6:{
                    // p("--->Report 3: Combo1 :-> 6 index selected");
                
                    msg = "Details of All Inactive Members :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 10); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));
					/*      +------+---------+--------+------+------+------------+------------+------------+
							| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
							+------+---------+--------+------+------+------------+------------+------------+        * /
							| 1003 | Hitest  | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | 2019-08-05 |
							| 1002 | Satya   | -      | -    | Fac. | 8787878787 | 2019-06-29 | 2019-07-31 |
							+------+---------+--------+------+------+------------+------------+------------+        */
                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];
                    
                    PdfPCell c1 = new PdfPCell(new Phrase("     Id"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("  Name"));
                    cells[1] = c1;
                    
                    c1 = new PdfPCell(new Phrase("  Class"));
                    cells[2] = c1;
                    
                    c1 = new PdfPCell(new Phrase("   Rno"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("  Type"));
                    cells[4] = c1;

                    c1 = new PdfPCell(new Phrase("  Ph.No."));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase(" Joined"));
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase("Last seen"));
                    c1.setPaddingLeft(0.0f);
                    c1.setPaddingRight(0.0f);
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }
                    table.setHeaderRows(1);
                    c1 = null;
                    
                    int rowNum = 0;
                    while(rs.next()){
					/*      +------+---------+--------+------+------+------------+------------+------------+
							| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
							+------+---------+--------+------+------+------------+------------+------------+        
						rs =   1       2         3       4       5       6           7              8           */
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                        c1.setPaddingLeft(10.0f);
                        cells[0] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;
                        
                        String memberClass;
                        String memberRno;
                        
                        if(rs.getString(5).equals("Stu.")){                 // if 'Type' = 'Stu.' then Store those 'Class' and 'Rno' value else Store '   -' in Table Cell...
                            memberClass = rs.getString(3);
                            memberRno = "" + rs.getLong(4);
                        }else{
                            memberClass = "    -";
                            memberRno = "  -";
                        }
                        c1 = new PdfPCell(new Phrase("" + memberClass));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(2.0f);
                        cells[2] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + memberRno));                        
                        
                        if( memberRno.length() < 6 )
                            c1.setPaddingLeft(14.0f);
                        else
                            c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getString(5)));
                        c1.setPaddingLeft(10.0f);
                        cells[4] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getLong(6)));
                        c1.setPaddingLeft(4.0f);
                        c1.setPaddingRight(4.0f);
                        cells[5] = c1;
						/*      +------+---------+--------+------+------+------------+------------+------------+
								| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
								+------+---------+--------+------+------+------------+------------+------------+        
							rs =   1       2         3       4       5       6           7              8               */

                        String formattedDate = getDateAsMonDateYear(rs.getString(7));         // Takes DOJ as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(7.0f);
                        c1.setPaddingRight(0.0f);
                        cells[6] = c1;

                        formattedDate = getDateAsMonDateYear(rs.getString(8));                // Takes LastSeen as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(7.0f);
                        c1.setPaddingRight(0.0f);
                        cells[7] = c1;
                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else 
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                    }
                    dc.add(table);
                    dc.add(new Paragraph(" "));
                    msg = "               :) Total Records Founds : "+rowNum;
                    dc.add(new Paragraph(msg));
                    dc.add(new Paragraph(" "));
                    // p("\nReport 3 : Combo 1 :- Case 6: Ended");
                    break;
                
                }
                case 7:{
                    // p("--->Report 3: Combo3 :-> 7 index selected");
                    
                    msg = "Details of All Library Members :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 10); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));
					/*      +------+---------+--------+------+------+------------+------------+------------+
							| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
							+------+---------+--------+------+------+------------+------------+------------+        * /
							| 1003 | Hitest  | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | 2019-08-05 |
							| 1002 | Satya   | -      | -    | Fac. | 8787878787 | 2019-06-29 | 2019-07-31 |
							+------+---------+--------+------+------+------------+------------+------------+        */
                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];
                    
                    PdfPCell c1 = new PdfPCell(new Phrase("    Id"));
                    cells[0] = c1;
//                        table.addCell(c1);
                    c1 = new PdfPCell(new Phrase("  Name"));
                    cells[1] = c1;
                    
                    c1 = new PdfPCell(new Phrase("  Class"));
                    cells[2] = c1;
                    
                    c1 = new PdfPCell(new Phrase(" Roll No"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("   Type"));
                    cells[4] = c1;
//                        table.addCell(c1);
                    c1 = new PdfPCell(new Phrase(" Ph. No."));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase(" Joined"));
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase("Last seen"));
                    c1.setPaddingLeft(0.0f);
                    c1.setPaddingRight(0.0f);
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);     //p("\ntable.getTotalHeight() ==> "+table.getTotalHeight());
                    c1 = null;
                    
                    int rowNum = 0;

                    while(rs.next()){
					/*      +------+---------+--------+------+------+------------+------------+------------+
							| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
							+------+---------+--------+------+------+------------+------------+------------+        
						rs =   1       2         3       4       5       6           7              8               */
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(1)));
                        c1.setPaddingLeft(10.0f);
                        cells[0] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getString(2)));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;
                        
                        String memberClass;
                        String memberRno;
                        
                        if(rs.getString(5).equals("Stu.")){                 // if 'Type' = 'Stu.' then Store those 'Class' and 'Rno' value else Store '   -' in Table Cell...
                            memberClass = rs.getString(3);
                            memberRno = "" + rs.getLong(4);
                        }else{
                            memberClass = "  -";
                            memberRno = "  -";
                        }
                        c1 = new PdfPCell(new Phrase(memberClass));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[2] = c1;
                        
                        c1 = new PdfPCell(new Phrase(memberRno));
                        if( memberRno.length() < 6 )
                            c1.setPaddingLeft(12.0f);
                        else
                            c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getString(5)));
                        c1.setPaddingLeft(10.0f);
                        cells[4] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getLong(6)));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(3.0f);
                        cells[5] = c1;
						/*      +------+---------+--------+------+------+------------+------------+------------+
								| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
								+------+---------+--------+------+------+------------+------------+------------+        
							rs =   1       2         3       4       5       6           7              8               */

                        String formattedDate = getDateAsMonDateYear(rs.getString(7));           // Takes DOJ as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(8.0f);
                        c1.setPaddingRight(2.0f);
                        cells[6] = c1;

                        formattedDate = getDateAsMonDateYear(rs.getString(8));                  // Takes LastSeen as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + formattedDate));
                        c1.setPaddingLeft(8.0f);
                        c1.setPaddingRight(2.0f);
                        cells[7] = c1;

                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else 
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                    }
                    dc.add(table);
                    dc.add(new Paragraph(" "));
                    msg = "               :) Total Records Founds : "+rowNum;
                    dc.add(new Paragraph(msg));
                    dc.add(new Paragraph(" "));
                    // p("\nReport 3 : Combo 1 :- Case 7: Ended");
                    break;                
                }
            }
            
        }catch(Exception e){
            msg = "----------- Some Information could not print Properly, Retry -----------";
            try {   dc.add(new Paragraph(msg)); }
            catch (Exception ee) { p("\nException in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());   }
            p("\n9898aa Exception in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());
        }
        return dc;
    }
    public Document setReport4InTable(Document dc, ResultSet rs, int selInd){
		p("\nDocument setReport4InTable( , , ) called...");
        String msg = "";
        switch(selInd)
        {
            case 1:
            {
                /*  +----------+-------+-----+----------+----------+--------+------+-----------+
                    | Name     | Code  | Qty | Author 1 | Author 2 | Price  | Rack | Available |
                    +----------+-------+-----+----------+----------+--------+------+-----------+
                    | Cpp Book | 10002 |   5 | Kallo    | Mangal   | 300.00 |    2 |         3 |    * /
                    | Cpp 1.17 | 10003 |   5 | lalaji   | -        | 100.00 |    3 |         3 |
                    +----------+-------+-----+----------+----------+--------+------+-----------+    */
                try
                {
                    msg = "Details of All Books that are Available Now :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 8); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));
					/*  +----------+-------+-----+----------+----------+--------+------+-----------+
						| Name     | Code  | Qty | Author 1 | Author 2 | Price  | Rack | Available |
						+----------+-------+-----+----------+----------+--------+------+-----------+
						| Cpp Book | 10002 |   5 | Kallo    | Mangal   | 300.00 |    2 |         3 |    */
                
                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];

                    PdfPCell c1 = new PdfPCell(new Phrase(" Name"));
                    cells[0] = c1;
					//                        table.addCell(c1);
                    c1 = new PdfPCell(new Phrase("  Code"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("   Qty."));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("Author 1"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("Author 2"));
                    cells[4] = c1;
					//                        table.addCell(c1);
                    c1 = new PdfPCell(new Phrase(" Price"));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase("   Rack"));
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase(" Available"));
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }
                    table.setHeaderRows(1);
                    c1 = null;

                    int rowNum = 0;

                    while(rs.next())
                    {
                    /*  +----------+-------+-----+----------+----------+--------+------+-----------+
                        | Name     | Code  | Qty | Author 1 | Author 2 | Price  | Rack | Available |
                        +----------+-------+-----+----------+----------+--------+------+-----------+
                        | Cpp Book | 10002 |   5 | Kallo    | Mangal   | 300.00 |    2 |         3 |
                        rs = 1         2       3     4          5           6        7           8      */
                        
                        c1 = new PdfPCell(new Phrase( rs.getString(1) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[0] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(2)));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;

                        String memberClass;
                        String memberRno;

						//                        if(rs.getString(5).equals("Stu.")){                 // if 'Type' = 'Stu.' then Store those 'Class' and 'Rno' value else Store '   -' in Table Cell...
						//                            memberClass = rs.getString(3);
						//                            memberRno = "" + rs.getLong(4);
						//                        }else{
						//                            memberClass = "  -";
						//                            memberRno = "  -";
						//                        }

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(3)));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(2.0f);
                        cells[2] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(4) ));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(5) ));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[4] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getDouble(6)));
                        c1.setPaddingLeft(3.0f);
                        c1.setPaddingRight(2.0f);
                        cells[5] = c1;
                        /*  +----------+-------+-----+----------+----------+--------+------+-----------+
                            | Name     | Code  | Qty | Author 1 | Author 2 | Price  | Rack | Available |
                            +--1-------+--2----+---3-+---4------+---5------+---6----+---7--+-----8-----+
                            | Cpp Book | 10002 |   5 | Kallo    | Mangal   | 300.00 |   2 |     3 |    */

						//                        String formattedDate = getDateAsMonDateYear(rs.getString(7));           // Takes DOJ as : "2019-03-27"  Returns : "Mar 27,19"...
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(7) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(2.0f);
                        cells[6] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(8) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(2.0f);
                        cells[7] = c1;

                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else {
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                        }
                    }
                        dc.add(table);
                        dc.add(new Paragraph(" "));
                        msg = "               :) Total Records Founds : "+rowNum;
                        dc.add(new Paragraph(msg));
                        dc.add(new Paragraph(" "));
                        p("\nReport 4 : Combo 1 :- Case 1: Ended");
                        
                    
                }catch(Exception e){
                    msg = "----------- Some Information could not print Properly, Retry -----------";
                    try {   dc.add(new Paragraph(msg)); }
                    catch (Exception ee) { p("\nException in creteReport4(_,_,_) , ee.getMessage() =>" + e.getMessage());   }
                    p("\n9988ss Exception in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());            
                }
                return dc;
            }
        
            case 2:
            {

                try{
                    // p("--->Report 4: Combo4 :-> 2 Index Selected : 'All Books that are Issued' ");

                    msg = "Details of All Books that are Issued :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 8); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));
                    /*  +-----------+----------+---------+------+------+-------------+-------------+----------+
                        | Name      | BookCode | Member  | M_Id | Type | issuedOn    | LastDate    | DaysLeft |
                        +-----------+----------+---------+------+------+-------------+-------------+----------+     / *
                    RS==| Cpp 1.17  |    10003 | Shubham | 1003 | Stu. | Aug 06,2019 | Sep 06,2019 |       53 |
                        | Java book |    10001 | Jitu    | 1011 | Fac. | Jul 02,2019 | Aug 02,2019 |       18 |
                        +-----------+----------+---------+------+------+-------------+-------------+----------+    */
                    
                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];

                    PdfPCell c1 = new PdfPCell(new Phrase(" Name"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("  Code"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase(" Member"));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("    Id"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("  Type"));
                    cells[4] = c1;
    //                        table.addCell(c1);
                    c1 = new PdfPCell(new Phrase("Issued On"));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase("Last Date"));
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase("Days left"));
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);     //p("\ntable.getTotalHeight() ==> "+table.getTotalHeight());
                    c1 = null;

                    int rowNum = 0;

                    while(rs.next())
                    {
                    /*  +-----------+----------+---------+------+------+-------------+-------------+----------+
                        | Name      | BookCode | Member  | M_Id | Type | issuedOn    | LastDate    | DaysLeft |
                        +---1-------+----2-----+---3-----+--4---+---5--+-----6-------+-----7-------+----8-----+
                    RS==| Cpp 1.17  |  10003   | Shubham | 1003 | Stu. | Aug 06,2019 | Sep 06,2019 |   53     |     */
                        
                        c1 = new PdfPCell(new Phrase( rs.getString(1) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[0] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(2)));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(3) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[2] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(4) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(2.0f);
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(5) ));
                        c1.setPaddingLeft(8.0f);                        
                        cells[4] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(6) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[5] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(7) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[6] = c1;
                        /*  +-----------+----------+---------+------+------+-------------+-------------+----------+
                            | Name      | BookCode | Member  | M_Id | Type | issuedOn    | LastDate    | DaysLeft |
                            +---1-------+----2-----+---3-----+--4---+---5--+-----6-------+-----7-------+----8-----+
                        RS==| Cpp 1.17  |    10003 | Shubham | 1003 | Stu. | Aug 06,2019 | Sep 06,2019 |       53 |     */
                        


                        c1 = new PdfPCell(new Phrase("" + rs.getInt(8) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(2.0f);
                        cells[7] = c1;

                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else {
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                        }
                    }
                        dc.add(table);
                        dc.add(new Paragraph(" "));
                        msg = "               :) Total Records Founds : "+rowNum;
                        dc.add(new Paragraph(msg));
                        dc.add(new Paragraph(" "));
                        p("\nReport 4 : Combo 1 :- Case 2: Ended");                        
                    
                }catch(Exception e){
                    msg = "----------- Some Information could not print Properly, Retry -----------";
                    try {   dc.add(new Paragraph(msg)); }
                    catch (Exception ee) { p("\nException in creteReport4(_,_,_) , ee.getMessage() =>" + e.getMessage());   }
                    p("\n9009as Exception in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());            
                }
                return dc;
            }
            
            case 3:
            {
                    /*  +-----------+-------+-----+----------+----------+--------+------+-----------+
                        | Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | On Repair |
                        +-----------+-------+-----+----------+----------+--------+------+-----------+
                        | Java book | 10001 |   3 | lala     | -        | 799.00 |    1 |         1 |
                        | Cpp 1.17  | 10003 |   5 | lalaji   | -        | 100.00 |    3 |         2 |
                        +-----------+-------+-----+----------+----------+--------+------+-----------+   */

                try{
                    // p("--->Report 4: Combo4 :-> 3 Index Selected : 'All Books gone for Repairing '");

                    msg = "Details of All Books gone for Repairing :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 8); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));
                    /*  +-----------+-------+-----+----------+----------+--------+------+-----------+
                        | Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | On Repair |
                        +--1--------+--2----+--3--+----4-----+----5-----+---6----+--7---+-----8-----+
                        | Java book | 10001 |  3  | lala     | -        | 799.00 |  1   |     1     |   */
                    
                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];

                    PdfPCell c1 = new PdfPCell(new Phrase("  Name"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("  Code"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("Quantity"));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("Author 1"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("Author 2"));
                    cells[4] = c1;
    //                        table.addCell(c1);
                    c1 = new PdfPCell(new Phrase(" Price"));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase("  Rack"));
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase("On Repair"));
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);     //p("\ntable.getTotalHeight() ==> "+table.getTotalHeight());
                    c1 = null;

                    int rowNum = 0;

                    while(rs.next())
                    {
                    /*  +-----------+-------+-----+----------+----------+--------+------+-----------+
                        | Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | On Repair |
                        +--1--------+--2----+--3--+----4-----+----5-----+---6----+--7---+-----8-----+
                        | Java book | 10001 |   3 | lala     | -        | 799.00 |    1 |         1 |   */
                    
                        c1 = new PdfPCell(new Phrase( rs.getString(1) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[0] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(2)));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;

                        c1 = new PdfPCell(new Phrase( ""+rs.getInt(3) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(1.0f);
                        cells[2] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(4) ));
                        c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[3] = c1;

                        String author2 = rs.getString(5);
                        c1 = new PdfPCell(new Phrase( author2 ));
                        if(author2.length() < 5 )c1.setPaddingLeft(10.0f);
                        else c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(2.0f);
                        cells[4] = c1;

                        c1 = new PdfPCell(new Phrase( "" + rs.getDouble(6) ));
                        c1.setPaddingLeft(7.0f);
                        c1.setPaddingRight(1.0f);
                        cells[5] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(7) ));
                        c1.setPaddingLeft(12.0f);
                        c1.setPaddingRight(1.0f);
                        cells[6] = c1;
                    /*  +-----------+-------+-----+----------+----------+--------+------+-----------+
                        | Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | On Repair |
                        +--1--------+--2----+--3--+----4-----+----5-----+---6----+--7---+-----8-----+
                        | Java book | 10001 |   3 | lala     | -        | 799.00 |    1 |         1 |   */

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(8) ));
                        c1.setPaddingLeft(12.0f);
                        c1.setPaddingRight(1.0f);
                        cells[7] = c1;

                        rowNum++;
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        else {
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                        }
                    }
                        dc.add(table);
                        dc.add(new Paragraph(" "));
                        msg = "               :) Total Records Founds : "+rowNum;
                        dc.add(new Paragraph(msg));
                        dc.add(new Paragraph(" "));
                    
                }catch(Exception e){
                    msg = "----------- Some Information could not print Properly, Retry -----------";
                    try {   dc.add(new Paragraph(msg)); }
                    catch (Exception ee) { p("\nException in creteReport4(_,_,_) , ee.getMessage() =>" + e.getMessage());   }
                    p("\n4545aq Exception in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());            
                }
                return dc;
            }
            case 4:
            {
                /*  +-----------+-------+-----+--------+------+------+------------+----------------------------+
                    | Name      | Code  | Qty | Price  | Rack | M_Id | Date       | Reason                     |
                    +--1--------+---2---+--3--+---4----+---5--+--6---+-----7------+-------------8--------------+
                    | Java book | 10001 |   3 | 799.00 |    1 | 1004 | 2019-07-25 |   -                        |                
                    | Cpp Book  | 10002 |   5 | 300.00 |    2 |   -  | 2019-07-25 | Gandhi ji ko de diye       |    
                    +-----------+-------+-----+--------+------+------+------------+----------------------------+   */

                try{
                    p("--->Report 4: Combo4 :-> 4 Index Selected : 'All Books That are Destroyed'");

                    msg = "Details of All Books That are Destroyed :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 8); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));

                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];

                    PdfPCell c1 = new PdfPCell(new Phrase("  Name"));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("  Code"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("   Qty"));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase(" Price"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("   Rack"));
                    cells[4] = c1;
    //                        table.addCell(c1);
                    c1 = new PdfPCell(new Phrase("Mem. Id"));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase("   Date"));
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase(" Reason"));
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);     //p("\ntable.getTotalHeight() ==> "+table.getTotalHeight());
                    c1 = null;

                    int rowNum = 0;

                    while(rs.next())
                    {
                        /* +-----------+-------+-----+--------+------+------+------------+----------------------------+
                           | Name      | Code  | Qty | Price  | Rack | M_Id | Date       | Reason                     |
                           +--1--------+---2---+--3--+---4----+---5--+--6---+-----7------+-------------8--------------+
                           | Java book | 10001 |   3 | 799.00 |    1 | 1004 | 2019-07-25 |   -                        |                
                           | Cpp Book  | 10002 |   5 | 300.00 |    2 |   -  | 2019-07-25 | Gandhi ji ko de diye       |    
                           +-----------+-------+-----+--------+------+------+------------+----------------------------+   */

                        c1 = new PdfPCell(new Phrase( rs.getString(1) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[0] = c1;

                        c1 = new PdfPCell(new Phrase("" + rs.getInt(2)));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(2.0f);
                        cells[1] = c1;

                        c1 = new PdfPCell(new Phrase( ""+rs.getInt(3) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(1.0f);
                        cells[2] = c1;
                        
                        c1 = new PdfPCell(new Phrase( "" + rs.getDouble(4) ));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(1.0f);
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase( ""+rs.getInt(5) ));
                        c1.setPaddingLeft(12.0f);
                        c1.setPaddingRight(1.0f);
                        cells[4] = c1;
                        
                        String memberId = "";
                        try{
                            memberId = ""+rs.getInt(6);        // It can be : memberId : rs.getInt(6) = "1002" or rs.getInt(6) = "  -"
                        }catch(Exception e){
                            memberId = "   -";
                        }
                        c1 = new PdfPCell(new Phrase( ""+ memberId ));
                        c1.setPaddingLeft(6.0f);
                        c1.setPaddingRight(1.0f);
                        cells[5] = c1;
                        
                        String delDate = getDateAsMonDateYear(rs.getString(7));
                        c1 = new PdfPCell(new Phrase( delDate ));   // rs.getString(7) : '2019-07-25' => delDate : 'July 25,19'...
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(1.0f);
                        cells[6] = c1;
						
                        String reason = "";
                        try{
                            reason = ""+rs.getString(8);;        // It can be : reason : rs.getString(8) = "1002" or rs.getString(8) = "  -"
                        }catch(Exception e){
                            reason = "   -";
                        }
                        c1 = new PdfPCell(new Phrase( reason ));
                        if( reason.length() < 5 )c1.setPaddingLeft(13.0f);
                        else                     c1.setPaddingLeft(2.0f);
                        c1.setPaddingRight(1.0f);
                        cells[7] = c1;
                        /*  +-----------+-------+-----+--------+------+------+------------+----------------------------+
                            | Name      | Code  | Qty | Price  | Rack | M_Id | Date       | Reason                     |
                            +--1--------+---2---+--3--+---4----+---5--+--6---+-----7------+-------------8--------------+
                            | Java book | 10001 |   3 | 799.00 |    1 | 1004 | 2019-07-25 |   -                        |                
                            | Cpp Book  | 10002 |   5 | 300.00 |    2 |   -  | 2019-07-25 | Gandhi ji ko de diye       |    
                            +-----------+-------+-----+--------+------+------+------------+----------------------------+   */

                        
                        rowNum++;
                        if ((rowNum % 2) == 0){
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                            }
                        }
                        else {
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                        }
                    }

                        dc.add(table);
                        dc.add(new Paragraph(" "));
                        msg = "               :) Total Records Founds : "+rowNum;
                        dc.add(new Paragraph(msg));
                        dc.add(new Paragraph(" "));
                }catch(Exception e){
                    msg = "----------- Some Information could not print Properly, Retry -----------";
                    try {   dc.add(new Paragraph(msg));  }
                    catch (Exception ee){   p("\nException in creteReport4(_,_,_) , ee.getMessage() =>" + e.getMessage());   }
                    p("\n3453qq Exception in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());
                }
                return dc;
            }
            case 5:
            {   /*  Query 1 : ResultSet Data...
                    +--------------+---------+-------+-----------+--------+--------+-----------+
                    | BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed |
                    +--------------+---------+-------+-----------+--------+--------+-----------+
                    | Java book    |       3 | 10001 |         1 |      0 |      0 |         2 |
                    | Cpp Book     |       5 | 10002 |         3 |      1 |      0 |         1 |
                    | Cpp 1.17     |       5 | 10003 |         3 |      1 |      0 |         1 |
                    | Visual Basic |       4 | 10004 |         4 |      0 |      0 |         0 |
                    +--------------+---------+-------+-----------+--------+--------+-----------+

                    Query 2:
                        SELECT (Select count(*) from tbl_book_info) TotalBooks,
                        (Select count(*) from tbl_books) TotalQty,
                        (Select count(*) from tbl_books where status='A') Available,
                        (Select count(*) from tbl_books where status='I') Issued,
                        (Select count(*) from tbl_books where status='R') Repair,
                        (Select count(*) from tbl_books where status='D') Destroyed;

                    +------------+----------+-----------+--------+--------+-----------+
                    | TotalBooks | TotalQty | Available | Issued | Repair | Destroyed |
                    +------------+----------+-----------+--------+--------+-----------+
                    |          4 |       17 |        10 |      2 |      1 |         4 |
                    +------------+----------+-----------+--------+--------+-----------+     */

                try{
                    // p("--->Report 4: Combo4 :-> 5 Index Selected : 'All Books Details...'");

                    msg = "Details of All of the Books of Library :-";
                    dc.add(new Paragraph(" "));
                    dc.add(new Paragraph(msg));
                    String borderBtm = "";
                    for (int i = 0; i <= (msg.length() - 8); i++)   borderBtm += "_";
                    dc.add(new Paragraph(borderBtm));
                    dc.add(new Paragraph(" "));

                    PdfPTable table = new PdfPTable(8);
                    PdfPCell[] cells = null;
                    cells = new PdfPCell[8];

                    PdfPCell c1 = new PdfPCell(new Phrase("Sr. No."));
                    cells[0] = c1;

                    c1 = new PdfPCell(new Phrase("  Name"));
                    cells[1] = c1;

                    c1 = new PdfPCell(new Phrase("Book Qty"));
                    cells[2] = c1;

                    c1 = new PdfPCell(new Phrase("  Code"));
                    cells[3] = c1;

                    c1 = new PdfPCell(new Phrase("  Avb."));
                    cells[4] = c1;
    
                    c1 = new PdfPCell(new Phrase(" Issued"));
                    cells[5] = c1;

                    c1 = new PdfPCell(new Phrase(" Repair"));
                    cells[6] = c1;

                    c1 = new PdfPCell(new Phrase("Destroy"));
                    cells[7] = c1;

                    for (int i = 0; i < cells.length; i++) {
                        PdfPCell c = null;
                        c = cells[i];
                        c.setBackgroundColor(BaseColor.GREEN);
                        c.setPaddingTop(8.0f);
                        c.setPaddingBottom(9.0f);
                        table.addCell(c);
                    }                           // For Loop Ended ...
                    table.setHeaderRows(1);     //p("\ntable.getTotalHeight() ==> "+table.getTotalHeight());
                    c1 = null;

                    int rowNum = 0;

                    while(rs.next())
                    {
                        
                        /*      +----1---------+----2----+---3---+----4------+----5---+---6----+-----7-----+
                        rs=     | BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed |
                                +--------------+---------+-------+-----------+--------+--------+-----------+    */
                        
                        c1 = new PdfPCell(new Phrase( "" + (++rowNum) ));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(1.0f);
                        cells[0] = c1;

                        c1 = new PdfPCell(new Phrase( rs.getString(1) ));
                        c1.setPaddingLeft(1.0f);
                        c1.setPaddingRight(1.0f);
                        cells[1] = c1;

                        c1 = new PdfPCell(new Phrase( ""+rs.getInt(2) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(1.0f);
                        cells[2] = c1;
                        
                        c1 = new PdfPCell(new Phrase( "" + rs.getInt(3) ));
                        c1.setPaddingLeft(5.0f);
                        c1.setPaddingRight(1.0f);
                        cells[3] = c1;

                        c1 = new PdfPCell(new Phrase( ""+rs.getInt(4) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(1.0f);
                        cells[4] = c1;
                        
                        c1 = new PdfPCell(new Phrase( ""+rs.getInt(5) ));
                        c1.setPaddingLeft(10.0f);
                        c1.setPaddingRight(1.0f);
                        cells[5] = c1;
                        
                        c1 = new PdfPCell(new Phrase( ""+rs.getInt(6) ));
                        c1.setPaddingLeft(12.0f);
                        c1.setPaddingRight(1.0f);
                        cells[6] = c1;
                        
                        c1 = new PdfPCell(new Phrase("" + rs.getInt(7) ));
                        c1.setPaddingLeft(12.0f);
                        c1.setPaddingRight(1.0f);
                        cells[7] = c1;
                        
                        if ((rowNum % 2) == 0)
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                cells[i].setBackgroundColor(BaseColor.LIGHT_GRAY);
                                table.addCell(cells[i]);
                                
                            }
                        else {
                            for (int i = 0; i < cells.length; i++) {
                                cells[i].setPaddingTop(4.0f);
                                cells[i].setPaddingBottom(5.0f);
                                table.addCell(cells[i]);
                            }
                        }
                    }
                        dc.add(table);
                        /*  +--------------+---------+-------+-----------+--------+--------+-----------+
                            | BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed |
                            +--------------+---------+-------+-----------+--------+--------+-----------+   */
                        Connection con = getDbConnObj();
                        if(con != null){
                            Statement st = con.createStatement();
                            String sql= "Select (Select count(*) from tbl_books) TotalQty,  " +
                                        "       (Select count(*) from tbl_books where status='A') Available,  " +
                                        "       (Select count(*) from tbl_books where status='I') Issued,  " +
                                        "       (Select count(*) from tbl_books where status='R') Repair,  " +
                                        "       (Select count(*) from tbl_books where status='D') Destroyed;";
                                /*  +----1-----+-----2-----+----3---+----4---+-----5-----+
                                    | TotalQty | Available | Issued | Repair | Destroyed |
                                rs= +----------+-----------+--------+--------+-----------+
                                    |       17 |        10 |      2 |      1 |         4 |
                                    +----------+-----------+--------+--------+-----------+   */
                            rs = st.executeQuery(sql);
                            rs.next();

                            dc.add(new Paragraph(" "));
                            msg = "               :) More Informations : ";
                            dc.add(new Paragraph(msg));
                            dc.add(new Paragraph(" "));
                            msg = "                       *) Number of Books         : "+ rowNum;
                            dc.add(new Paragraph(msg));
                            dc.add(new Paragraph(" "));
                            msg = "                       *) Total Qty. of Books     : "+ rs.getLong(1);
                            dc.add(new Paragraph(msg));
                            dc.add(new Paragraph(" "));
                            msg = "                       *) Total Books Available : "+ rs.getLong(2);
                            dc.add(new Paragraph(msg));
                            dc.add(new Paragraph(" "));
                            msg = "                       *) Total Books Issued      : "+ rs.getLong(3);
                            dc.add(new Paragraph(msg));
                            dc.add(new Paragraph(" "));
                            msg = "                       *) Total Books on Repair  : "+ rs.getLong(4);
                            dc.add(new Paragraph(msg));
                            dc.add(new Paragraph(" "));
                            msg = "                       *) Total Books Destroyed : "+ rs.getLong(5);
                            dc.add(new Paragraph(msg));
                        }
                }catch(Exception e){
                    msg = "----------- Some Information could not print Properly, Retry -----------";
                    try {   dc.add(new Paragraph(msg));  }
                    catch (Exception ee){   p("\nException in creteReport4(_,_,_) , ee.getMessage() =>" + e.getMessage());   }
                    p("\nException in creteReport(_,_,_) , ee.getMessage() =>" + e.getMessage());
                }
                return dc;
            }
        }
        return dc;
    }
    public void setBkDel_C_Panel(){     // means : "pnlBkDelNow"                      Issued  Rep  Des  Available
        //  arrBkDel[]             = 10001   Java book     3   Programming   lala     799.00     1     0     0     2
        //  listBkDel.split("^^^") = [ 0       1           2      3            4        5        6     7     8     9  ];
        
        String arrBkDel[] = null;
        String listVal = "10001^^^Java book^^^3^^^Programming^^^lala^^^799.00^^^1^^^0^^^0^^^2";
                
        arrBkDel = (listBkRet.get(listBkDel_B.getSelectedIndex())).split("([\\^\\^\\^]+)");                         // Explaination...pnlBkDel_B me jo bhi index selected hoga at the time of Submission...Usi Index ke Corres. Global ListObject 'listBkRet' se .get(n) karke fetch hoga and split() karke String Arr 'arrBkDel' me store ho jaayega
        lblBkDelE_Bid.setText(  "Book Id : "+arrBkDel[0] );      // THESE ARE 'pnlBkDelNow' s Components...Book Delete Panel 3
        lblBkDelE_Bname.setText(arrBkDel[1] );
        lblBkDelE_Btype.setText(arrBkDel[3] );
        lblBkDelE_qty.setText(  arrBkDel[2] );
        lblBkDelE_auth.setText( arrBkDel[4] );

        lblBkDelE_nIss.setText( arrBkDel[6] );        
        lblBkDelE_nRep.setText( arrBkDel[7] );
        lblBkDelE_nDes.setText( arrBkDel[8] );
        lblBkDelE_nAva.setText( arrBkDel[9] );
        
        lblBkDel_E_Err.setText(" ");
        lblBkDel_E_Err.setForeground(new Color(240,0,0));
        txtAreaBkDel_E.setText("");
        txtBkDel_E_mid.setText("");

        lblBkDelE_rbtnMem.setSelected(true);
        pnlBkDelE_m.setVisible(true);   // Member lost subPanel...
        pnlBkDelE_o.setVisible(false);  // Other reason subPanel
    }
    public String getAccnoFor(String condition,int accid){
		/*  This method will Take ( "OtherReasonOfBookDeletion" , "10002" ) OR ( "MemberLostIt_BookDeletion", "10001")
			and Searches for "accid" in Database according to 'Condition'
			and Returns (tbl_books Accno( as String )Just Like : "103" )    OR ( "GeneratedException or CustomDefined ErrMsg" )   */
        try{
            String accno="NotFound";
            Connection con = getDbConnObj();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String sql = "";
            
            if(con == null)
                return "OOPs...Database Connection not Found, Retry Later !";                            // Flag accno
				//p("\n%%%%% Step 1");

            if(condition.equals("OtherReasonOfBookDeletion")){                                         // Query Used when pnlBkDelNow Submitted...with OtherReasonSelected:
                sql = "Select b.Accno Accno from tbl_books b where b.accid = ? and b.status = 'A' limit 1;";
                    //        +-------+
                    //        | Accno |
                    //Returns +-------+     Or      Returns Empty set when No Books are Available 
                    //        |   102 |
                    //        +-------+
                pstmt  = con.prepareStatement(sql);
                pstmt.setInt(1,accid);
                boolean isAff = pstmt.execute();                                                        // TRUE if the first result is a    ResultSet_Obj  came from a SELECT Stmt.  FALSE If result is an  UpdateCount  OR  there is no Result.

                if( isAff == false )                                                                    // There is no result
                        return "OOPs! Could Not Delete, Retry Later !";                                 // Flag accno

                rs = pstmt.getResultSet();
                if(rs.next() == false)                                                                  // No tabular Structure fetched...
                    return "OOPs! Can't Delete, as No Books are Available of Book[ "+ accid +" ]";      // Flag accno
                 
                else{
                    accno = ""+ rs.getInt(1);
                    return accno;
                }
            }else{                                                                                      // Query Used when pnlBkDelNow Submitted...with MemberLostBookSelected:
                sql = "Select b.Accno Accno from tbl_books b where b.accid = "+ accid +" and b.status = 'I' limit 1;";
				// p("\n%%%%% Step 5_5, sql ->\n"+sql+"\n");
				//                rs = st.executeQuery(sql);
                    //        +-------+
                    //        | Accno |
                    //        +-------+     Or returns Empty set when No Books are Issued
                    //        |   101 |
                    //        +-------+
                if(rs == null)
                    return "OOPs...Something Went Wrong, Retry Later !(Err:9004)";
                
                if(rs.next() == false)  
                    return "OOPs! Can't Delete, as No Books are Issued with Id="+ accid +".";          // Flag
                else
                    accno = ""+ rs.getInt(1);
				
                return accno;
            }
        }catch(Exception e){
            return ("OOPs...Something Went Wrong,(Err:9002),msg="+e.getMessage());                               // Flag
        }
    }    
    public String updateStatusInTblBooks(int accid, int accno){
        // This Method will Update the datebase Table 'tbl_books' , set Status = 'D'eleted, whose accid and accno are as specified...
            String retVal = "OOPs...Could not Updated, Retry Later !";
            try{
                Connection con = getDbConnObj();
                PreparedStatement pstmt = null;            
                if(con == null)
                    return "OOPs...Database is Not On, Retry Later !";                            // Flag accno
                String sql = "Update Tbl_books set status = 'D' where accid = ? and accno = ?;";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1,accid);
                pstmt.setInt(2,accno);
                int aff = pstmt.executeUpdate();
                if(aff != 1)
                    return ("OOPs...Could not Updated, Retry Later !");
                else 
                    return ("tbl_books is Updated Successfully");
                
            }catch(Exception e){
                return ("OOPs...Something Went Wrong,(Err:9002),msg="+e.getMessage());                               // Flag
            }        
        }
        public String checkIssuedNdSetOnPnl( String mId ){
            String retVal = "OOPs...Could Not Delete the Book, Retry Later !";                  // Flag
            try{
                Connection con = getDbConnObj();
                if(con == null)
                    return "OOPs...Database is Not On, Retry Later !";                          // Flag
                PreparedStatement pstmt = null;
                ResultSet rs = null;
            /*
                    "Select c.b_name Book, b.b_acc_id Accid, b.accno Accno, c.b_qty Qty, m.mName Member, b.m_Id M_Id, "+
                    "    (CASE WHEN m.mType='S'  "+
                    "        THEN (Select 'Stu.')  "+
                    "        ELSE (Select 'Fac.')  "+
                    "        END ) as 'Type',  "+
                    "    date_format(b.m_issDt,'%b %d,%y') IssuedOn, c.b_price Price,  "+
                    "    b.t_id TransId  "+
                    "from bktrans b,  "+
                    "    mems m ,  "+
                    "    tbl_book_info c   "+
                    "where b.m_id = 1008 and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null;  ";      
    
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+
                    | Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+
                    | Cpp Book  | 10002 |   102 |   5 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |       2 |
                    | Java book | 10001 |   103 |   3 | shubh  | 1008 | Fac. | Jul 19,19 | 799.00 |       5 |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+
                                                        ------ OR ------
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+
                    | Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+
                    | Cpp Book  | 10002 |   102 |   5 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |       2 |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+
            */
                String sql= "Select c.b_name Book, b.b_acc_id Accid, b.accno Accno, c.b_qty Qty, m.mName Member, b.m_Id M_Id, "+
                            "    (CASE WHEN m.mType='S'  "+
                            "        THEN (Select 'Stu.')  "+
                            "        ELSE (Select 'Fac.')  "+
                            "        END ) as 'Type',  "+
                            "    date_format(b.m_issDt,'%b %d,%y') IssuedOn, c.b_price Price,  "+
                            "    b.t_id TransId  "+
                            "From bktrans b,  "+
                            "    mems m ,  "+
                            "    tbl_book_info c   "+
                            "Where b.m_id = ? and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null;";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1,Integer.parseInt(mId));
                rs = pstmt.executeQuery();
                
                /*          rs =  +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+
                                  | Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId |
                                  +--1--------+---2---+---3---+--4--+---5----+--6---+--7---+----8------+---9----+----10---+         */
        }catch(SQLException se){    return "";    }
            catch(Exception e){    return "";    }
        return retVal;
    }
    public void handleAccidIssuedTo( String accid, String mId ){
        //   This method is Called from BkDel SubPnl 'C' Submission...and will Check : If Member[ mId ] had issued a book which has b_Acc_no = accid , Take as: (10001,1002){ ... } 
    
            String retVal = "";
            try{
                Connection con = getDbConnObj();
    
                if(con == null)
                    throw new Exception("OOPs...Database is Not On, Retry Later !");                                  // Flag
                
                PreparedStatement pstmt = null;
                ResultSet rs = null;            
                String sql= "Select c.b_name Book, b.b_acc_id Accid, b.accno Accno, c.b_qty Qty, m.mName Member, b.m_Id M_Id, "+
                            "    (CASE WHEN m.mType='S'  "+
                            "        THEN (Select 'Stu.')  "+
                            "        ELSE (Select 'Fac.')  "+
                            "        END ) as 'Type',  "+
                            "    date_format(b.m_issDt,'%b %d,%Y') IssuedOn, c.b_price Price,  "+
                            "    b.t_id TransId, " +
                            "    c.b_auth1 Author "+
                            "From bktrans b,  "+
                            "    mems m ,  "+
                            "    tbl_book_info c   "+
                            "Where b.m_id = ?  and b.m_actRetDt is null and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id;";
                /*      +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
                        | Book     | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn    | Price  | TransId | Author |
                        +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
                        | Cpp Book | 10002 |   101 |   5 | Bhatt  | 1010 | Fac. | Jul 16,2019 | 300.00 |       1 | Kallo  |
                        +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+       */
    
                //  This Query will Fetch Details of Member   b.m_id = ?   who has got a Book From Library and Not Returned ... came to pay as book is lost by him  ...    sql = Select c.b_name Book, b.b_acc_id Accid, b.accno Accno, c.b_qty Qty, m.mName Member, b.m_Id M_Id,     (CASE WHEN m.mType='S'          THEN (Select 'Stu.')          ELSE (Select 'Fac.')          END ) as 'Type',      date_format(b.m_issDt,'%b %d,%y') IssuedOn, c.b_price Price,      b.t_id TransId,     c.b_auth1 Author From bktrans b,      mems m ,      tbl_book_info c   Where b.m_id = ?  and b.m_actRetDt is null and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id; -- ? m_id  =  1001
                
                pstmt = con.prepareStatement( sql );
                pstmt.setInt(1,Integer.parseInt( mId ));
                rs = pstmt.executeQuery();
                if(rs == null)
                    throw new Exception("OOPs...Something went wrong, Retry Later, ErrId:9007");            
                
                if(rs.next() == false)
                    throw new Exception("OOPs...No Book are Issued to This Member[ "+ mId+" ]");			
                //  Check how many books are issued to this member and set them in a List 'JListBox' of pnlBkDel_D...
                
                boolean isAccidIssued =false;
                do{
                    String rsAccid = "" + rs.getInt("Accid");
                    if( accid.equals(rsAccid) ){                // `accid` is from  pnlBkDel_C ke "Book Id : 10002" se liya gya h...
                // Checking Book Lost : if the book that Member told  and   the book issued to him before is matched or Not,
                // Yes  : Set details on Book Delete Subpanel E "pnlBkDel_E", and 
                // No	: the Book( GIVEN accid) was Lost by Member...					
                        isAccidIssued = true;
                        setFinalBookDelPanel_E(rs,accid);
                        break;
                    }
                }while(rs.next());
                
                // Book( Accid ) is Not Issued to Member( mId ) : Now Sub_Panel_D par JListBox me Issued Book(s) ka Details aaa jaye...
                if(isAccidIssued == false){
                    setPnlBkDel_D(rs,accid);        // set on "pnlBkDel_D"
                }
      
                /*
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
                    | Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId | Author |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
                    | Cpp Book  | 10002 |   102 |   5 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |       2 | Kallo  |
                    | Java book | 10001 |   103 |   3 | shubh  | 1008 | Fac. | Jul 19,19 | 799.00 |       5 | lala   |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
    
                                                        ------ OR ------
                    Empty Set returned :
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
                    | Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId | Author |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
                    | Cpp Book  | 10002 |   102 |   5 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |       2 | Kallo  |
                    +-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+        */
                
                
        }catch(SQLException se){
            showMsgOnLbl("OOPs...Something Went Wrong,Retry Later ! (Err:9005)", lblBkDel_E_Err );
        }catch(Exception e){
            lblBkDel_E_Err.setVisible(true);
            showMsgOnLbl(e.getMessage(), lblBkDel_E_Err );
        }
    }
    public void setPnlBkDel_D(ResultSet rs, String accidNotIssued){                 // <--- search as "setPnlBkDel_D  (rs,accid);"
    try{
        p("\n%%%% setPnlBkDel_D( , , ) invoked... 2.2.1 going to set");
        rs.first();
        listBkRet = null;
        listBkRet = new java.util.ArrayList<>();


        String Book, Accid, Accno ,Qty , Member, M_Id, Type, IssuedOn, Price, TransId, Author;
        String sep = "^^^",row="";
        int k = 0;            
        
        do{
            k++;
            Book = rs.getString(1);
            Accid = ""+rs.getInt(2);
            Accno = ""+rs.getInt(3);
            Qty = ""+rs.getInt(4);
            Member = rs.getString(5);
            M_Id = ""+rs.getInt(6);
            Type = rs.getString(7);
            IssuedOn = rs.getString(8);
            Price = ""+ rs.getDouble(9);
            TransId = ""+rs.getInt(10);
            Author = rs.getString(11);
            row = Book + sep + Accid + sep + Accno + sep + Qty  + sep + Member + sep + M_Id + sep + Type + sep + IssuedOn + sep + Price + sep + TransId + sep + Author;
                                                                                                // Exception Generated while adding in listBkRet : 1) UnsupportedOperationException - if the add operation is not supported by this collection ClassCastException - if the class of the specified element prevents it from being added to this collection NullPointerException - if the specified element is null and this collection does not permit null elements IllegalArgumentException - if some property of the element prevents it from being added to this collection IllegalStateException - if the element cannot */
            listBkRet.add(row);

        }while(rs.next());


        
        lblMetaInfoInBkDel_D.setBackground(new Color(200,200,200));
        lblMetaInfoInBkDel_D.setText( "Book ["+ accidNotIssued +"] not Issued to "+Member+"["+ M_Id +"], Only "+ k +" Issued Book(s) are -");

        // Book[10010] not Issued to Ramanujan shing[1001], Only 2 Issued Book(s) are -
        try {
            listBkDel_D.setModel(                                // This is a JListBox of BkDelPnl_B...
                new javax.swing.AbstractListModel<String>() {
                    
                    String[] strings = getDelBooksRecords("forBkDelPanel_D");
                    
                    public int getSize() {  return strings.length;  }

                    public String getElementAt(int i) {    return strings[i];    }
                }
            );                
        } catch (Exception e) {
            p("\n !!! Nominal Exception from 'del_Bk_2_JList setter'- ... May be IllegalArgumentException occured ~4660 when Setting String to ReturnSubPnl_B_Listbox ,err = >" + e.getMessage()+"<-");
        }
        
            listBkDel_D.setSelectedIndex(0);
            showOnlyPanel("pnlBkDel_D");
        // Till Now...
        //  1) The Book issue to this Member had store in GlobalListObj...
        //  2) Book Delete subpanel D 'pnlBkDel_D' will visible...
        //  listBkRet        - Global Object       : to store ResultSet Information ...
        //  listBkDel_D      - pnlBkDel_D listBox  : to show issued book to the member[ rs.getInt("M_Id")];

        }catch(Exception e){
            p(" !!! Exception occured msg = "+  e.getMessage());
        }
    }

    public void setFinalBookDelPanel_E(int selInd){                 // --> search as "setFinalBookDelPanel_E(selInd);"
    // This method is called in series... when 'Book Delete SubPanel D "pnlBkDel_D" is Submitted ( 'Selected' & Submitted)'
		p("\ninvoked... setFinalBookDelPanel_E( , ) 0.01 listVal=>"+ bookInfos +"<= ");        
        String arrBkDel[] = null;
        String bookInfos = listBkRet.get(selInd);
        arrBkDel = bookInfos.split("([\\^\\^\\^]+)");                                         // Explaination...pnlBkDel_B me jo bhi index selected hoga at the time of Submission...Usi Index ke Corres. Global ListObject 'listBkRet' se .get(n) karke fetch hoga and split() karke String Arr 'arrBkDel' me store ho jaayega

        
					/*  +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
						| Book     | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn    | Price  | TransId | Author |
						+----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
						| Cpp Book | 10002 |   101 |   5 | Bhatt  | 1010 | Fac. | Jul 16,2019 | 300.00 |       1 | Kallo  |
            arrBkDel[] :+-----0----+---1---+----2--+---3-+---4----+---5--+--6---+------7------+----8---+-----9---+---10---+
            listBkRet.get(selInd) = "Cpp Book^^^10002^^^101^^^5^^^Bhatt^^^1010^^^Fac.^^^Jul 16,2019^^^300.00^^^1^^^Kallo";

            After spliting listVal ...
              arrBkDel[]:  0=>Cpp 1.17     1=>10003    2=>101  3=>5    4=>Bhatt    5=>1010   6=>Fac.   7=>Jul 22,2019  8=>100.0    9=>8    10=>lalaji     from : //  p("\nData to set on pnlBkDel_E ....");int i=0;for(String s : arrBkDel)p((i++)+"=>"+s);     */

        String Book = arrBkDel[0] ,Accid = arrBkDel[1] , Accno = arrBkDel[2] , Qty = arrBkDel[3] , Member = arrBkDel[4] , M_Id = arrBkDel[5] , Type = arrBkDel[6] ,
                      IssuedOn = arrBkDel[7] , Price = arrBkDel[8] , TransId = arrBkDel[9], Author = arrBkDel[10];

        String currDate = getDate_DyDtMnYr(Calendar.getInstance());
        currDate = currDate.substring(4);                                                      // "Wed Jan 12,2019".substring(4) --> "Jan 12,2019"...
        
        lblBk_R_B_mId1.setText(""+M_Id);
        lblBk_R_B_bId1.setText(""+Accid);

        lblBk_R_B_mNm1.setText(Member);
        lblBk_R_B_bNm1.setText(Book);

        lblBk_R_B_mType1.setText(Type);
        lblBk_R_B_bAuth1.setText(Author);

        lblBk_R_B_bIssDt1.setText(currDate);
        lblBk_R_B_bLastDt2.setText(IssuedOn);

        lblBk_R_B_bNm3.setText(Book);
        lblBk_I_D_mNm4.setText(Member);
        
        lblFineCalc1.setText("Rupees "+Price);
        btnRetBkRecv1.setText("Receive");
        lblBkR_B_err1.setText("  ");
        
		// Resetting Global Obj 'listBkRet' with All the Information of Book ...
		// that was selected in Book Deletion SubPanel_D: 'pnlBkDel_D' ...
        listBkRet = null;
        listBkRet = new java.util.ArrayList<>();
        listBkRet.add(bookInfos);
        showOnlyPanel("pnlBkDel_E");
    }
    public void setFinalBookDelPanel_E( ResultSet rs, String accidToDel ){
		//  This method is called in Series when BkDel SubPnl C is submitted...// <-- search like setFinalBookDelPanel_ E(rs,accid)

        int selInd = listBkDel_D.getSelectedIndex();
        String Book ,Accid , Accno , Qty , Member , M_Id , Type , IssuedOn , Price , TransId, Author, currDate;
        try{
            rs.beforeFirst();
            while(rs.next()){
                if( accidToDel.equals( ""+ rs.getInt("Accid")))
                    break;
            }
			/*      Only 1: +----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
							| Book     | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn    | Price  | TransId | Author |
							+----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+
							| Cpp Book | 10002 |   101 |   5 | Bhatt  | 1010 | Fac. | Jul 16,2019 | 300.00 |       1 | Kallo  |
							+----------+-------+-------+-----+--------+------+------+-------------+--------+---------+--------+         */
            Book = rs.getString(1);
            Accid = ""+rs.getInt(2);
            Accno = ""+rs.getInt(3);
            Qty = ""+rs.getInt(4);
            Member = rs.getString(5);
            M_Id = ""+rs.getInt(6);
            Type = rs.getString(7); if(Type.equalsIgnoreCase("Stu.")) Type="Student"; else Type="Faculty";
            IssuedOn = rs.getString(8);
            Price = ""+rs.getDouble(9);
            TransId = ""+rs.getInt(10);
            Author = rs.getString(11);
            
            currDate = getDate_DyDtMnYr(Calendar.getInstance());
            currDate = currDate.substring(4);       // "Wed Jan 12,2019".substring(4) --> "Jan 12,2019"...
            
        }catch(SQLException se){
            lblBkDel_E_Err.setVisible(true);
            lblBkDel_E_Err.setText("OOPs...Something Went Wrong, Retry Later ![ErrId:9008]");
            return;
        }catch(Exception e){
            lblBkDel_E_Err.setVisible(true);
            lblBkDel_E_Err.setText("OOPs...Something Went Wrong, Retry Later ![ErrId:9009]");
            return;
        }
        
        lblBk_R_B_mId1.setText(""+M_Id);
        lblBk_R_B_bId1.setText(""+Accid);

        lblBk_R_B_mNm1.setText(Member);
        lblBk_R_B_bNm1.setText(Book);

        lblBk_R_B_mType1.setText(Type);
        lblBk_R_B_bAuth1.setText(Author);

        lblBk_R_B_bIssDt1.setText(currDate);
        lblBk_R_B_bLastDt2.setText(IssuedOn);

        lblBk_R_B_bNm3.setText(Book);
        lblBk_I_D_mNm4.setText(Member);
        
        lblFineCalc1.setText("Rupees "+Price);
        btnRetBkRecv1.setText("Receive");
        lblBkR_B_err1.setText("  ");
        
        // Resetting Global ArrayList Collection Object...
        String sep = "^^^";
        String finalDelBookInfo = Book + sep + Accid + sep + Accno + sep + Qty + sep + Member + sep + M_Id + sep + Type + sep + IssuedOn + sep + Price + sep + 
                TransId + sep + Author;
		// p("\n### memIdSub...public void setFinalBookDelPanel_E( ResultSet rs, String accidToDel ) , \n\t\t finalDelBookInfo= "+finalDelBookInfo);
        listBkRet = null;
        listBkRet = new java.util.ArrayList<>();
        try{
            listBkRet.add( finalDelBookInfo );
        }catch(Exception e){
            p("\n\nOOPs... Nominal Excception occured in -> public void setFinalBookDelPanel_E( ResultSet rs, String accidToDel )\n");
        }
        
        showOnlyPanel("pnlBkDel_E");                                                    // From BookDeletionPanel_C ('pnlBkDelNow') to   BookDeletionPanel_E ('pnlBkDel_E')...
    }
    public String updateStatusInTbl_books( int accid,int accno ){
		//  This method will invoked when Book Deletion SubPanel E : 'pnlBkDel_E'   will be submitted...
		//      and will Update the 'Status' of Book[10001][101] from 'A' OR 'I' TO 'D', AND returns numOfRowAff...
        p("\nupdateStatusInTbl_books() invoked...");
		try{			
            Connection con = getDbConnObj();
            if(con == null)
                return "OOPs...Database Connection not Found, Check & Retry !";
            PreparedStatement pstmt = null;
            String sql = "Update Tbl_books set status = 'D' where accid = ? and accno = ?; ";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,accid);
            pstmt.setInt(2,accno);
            int aff = pstmt.executeUpdate();            
            return (aff+"");
        }catch(SQLException e){
            return "";
        }catch(Exception e){
            return "";
        }        
    }
    public String insertIntoTblBookDel( int accid, int accno, String condition ){   
        p("\ninsertIntoTblBookDel( , , ) invoked...");
		try{   // condition obj can be "otherMemberSelected" OR "MemberLostTheBook"
            
            Connection con = getDbConnObj();
            if(con == null)
                return "OOPs...Database Connection Not Found, Check & Retry";
            
            PreparedStatement pstmt = null;        
            String curryyyymmdd = getDbInsertableCurrentDate();
            String sql;

            if( condition.equals("otherMemberSelected" )){
            // If 'Other Member lost the book' Radio Btn of pnlBkDelNow's Submitted...
                String reason = txtAreaBkDel_E.getText();                
                sql  = "Insert Into bkDel( accid, accno, reason, deldate )\n" +
                            "Values( ?, ?, ?, ? );";                            //Insert Into bkDel( accid, accno, reason, deldate )Values( 10001, 102, 'Rat ruined this.', date(sysdate()) );
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1,accid);
                pstmt.setInt(2,accno);
                pstmt.setString(3,reason);            
                pstmt.setString(4,curryyyymmdd);
                int aff = pstmt.executeUpdate();
                if(aff != 1)
                    return "OOPs...Could Not Delete Book , Retry Later !";      // Need RollBack
                else
                    return "Table bkDel is Updated Successfully";
                
            }else{
				// Else "MemberLostTheBook"  <--- Search by this to reach on Called Pos.

				/*  Insert Into bkDel( m_Id, accid, accno, deldate )                -- when Member Lost the Book...
                 Values( 1004, 10001, 102, date(sysdate()) );    */
                if(btnRetBkRecv1.getText().equals("Receive"))
				//  p("*** a-4.01 returning as Exception ...\n as Book Lost Fine is not Charged, click ->Received<- !");
                    return "OOPs...Book Lost Fine ( "+ lblFineCalc1.getText() + " ) is not Charged, click ->Receive<- !";
                
                String []arrBkDel = (listBkRet.get(0)).split("([\\^\\^\\^]+)");
                    //  | Book     | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn    | Price  | TransId | Author |
                    //  finalDelBookInfo = "Java book^^^10001^^^101^^^3^^^Rohit^^^1007^^^Student^^^Jul 16,2019^^^799.0^^^3^^^lala";                    
                    //  arr 0 =>Java book<=    arr 1 =>10001<=    arr 2 =>101<=    arr 3 =>3<=	 arr 4 =>Rohit<=     arr 5 =>1007<=    arr 6 =>Student<=     arr 7 =>Jul 16,2019<=    arr 8 =>799.0<=	  arr 9 =>3<=    arr 10 =>lala<=
                
                int mId = Integer.parseInt(arrBkDel[5]);
                sql = "Insert Into bkDel( m_Id, accid, accno, deldate )" +
                        "Values( ?, ?, ?, ? );";
                
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1,mId);
                pstmt.setInt(2,accid);
                pstmt.setInt(3,accno);
                pstmt.setString(4,curryyyymmdd);                                            // 'yyyy-mm-dd'
                String aff = ""+pstmt.executeUpdate();
                if( aff.equals("1") ){
                    
                    // Update the bktrans table : Remove 'null' Set 'CurrentDate' from 'Actual Return date Attr.'...
                    int bkTransId = Integer.parseInt(arrBkDel[9]);
                    sql = "Update bktrans set m_actRetDt = ? where t_id = ?;";
                    pstmt = null;
                    pstmt = con.prepareStatement(sql);
                    pstmt.setString(1,curryyyymmdd);
                    pstmt.setInt( 2, bkTransId );
                    aff = ""+ pstmt.executeUpdate();
                    return aff;
                    
                }
                else
                    return "OOPs...Could Not Delete Book, Retry Later ![ErrId:9011]";       // Need RollBack
            }
        }catch(SQLException se){
            return "OOPs...Something went Wrong, Retry Later ![ErrId:9012]";                // Need RollBack
        
        }catch(Exception e){
            return "OOPs...Could Not Delete Book , Retry Later ![ErrId:9012]";              // Need RollBack
        }
    }
    public void runReport4(String prefixOfReport4){
		p("\nrunReport4() ...");
        try{
          // prefixOfReport4'll hold = "Set @counter := 0, @counterQty := 0, @counterAvb := 0, @counterIss := 0, @counterRep := 0 ,@counterDes:= 0;";
            p("\nExe... runReport4(String prefixOfReport4)\n");
            Connection con = getDbConnObj();
            Statement st = con.createStatement();
            st.execute(prefixOfReport4);
            p("\nEnded... runReport4(String prefixOfReport4)\n");
        }catch(Exception e){
            p("!!! Exception in 'runReport4(String prefixOfReport4)' , msg = "+e.getMessage());
        }
    }
    public void issueTheBook(){
        p("\n issueTheBook() called...");
        try {
            lblBkI_A_err.setForeground(Color.red);
            lblBkI_A_Data.setText("");
            if (isMemShipExpUpdated == -1 || isMemShipExpUpdated == -2) {
			// SQLExc... || Exc... occured 
                p("SQLExc... || Exc... occured in chk_UpdtMem_ship( ) , isMemShipExpUpdated = " + isMemShipExpUpdated);
                isMemShipExpUpdated = check_UpdateExpiryOfMem_ship();
                p("Again Trying...chk(), isMemShipExpUpdated = " + isMemShipExpUpdated);
                if (isMemShipExpUpdated == -1 || isMemShipExpUpdated == -2) {
                    //             Membership Not Updated...
                    lblBkI_A_err.setVisible(true);
                    lblBkI_A_err.setText("OOPs...Connection Failed, Re-Start MySql Database !");
                    lblBkI_A_Data.setEditable(false);
                    lblBkI_A_Data.setToolTipText("Restart MySQL Database to Enter the Member Id for Issuing book.");
                }
            } else {
                // This Time Membership Updated...SUCCESFULLY                
                lblBkI_A_err.setText("");
                lblBkI_A_err.setVisible(false);
                lblBkI_A_Data.setEditable(true);
                lblBkI_A_Data.setToolTipText("Enter the Member Id for Issuing book.");
            }
            showOnlyPanel("pnlBkIssue");
            pnlBkI_B.setVisible(false);
            pnlBkI_C.setVisible(false);
            pnlBkI_D.setVisible(false);
            pnlBkI_A.setVisible(true);
            btnBkI_A_show.setVisible(false); // Appears when The Enter mem Already Took One/More Books...
        } catch (Exception e) {        }
    }
    public void returnTheBook(){
        showOnlyPanel("pnlBkRet");
        lblBkR_A_Data.setText("");
        pnlBk_R_B.setVisible(false);
        pnlBk_R_C.setVisible(false);
        pnlBk_R_A.setVisible(true);
        lblBkR_A_err.setForeground(new Color(255, 0, 0));
        lblBkR_A_err.setText("");
    }
    public void generateReport(){
        showOnlyPanel("pnlReport");
        reportErr.setText("");
        reportErr.setForeground(new java.awt.Color(255, 0, 0));
        if (isMemShipExpUpdated == -1 || isMemShipExpUpdated == -2) // -1 Represents : This method didn't Updated mStatus of mem_ship
            isMemShipExpUpdated = check_UpdateExpiryOfMem_ship();

//        int a3=pnlReport.getX();
//        int a4=pnlReport.getY();
//        int a1=pnlReport.getWidth();
//        int a2=pnlReport.getHeight();
//        pnlReport.setBounds(0,119,994,679);
        resetReportComps();
        p("Report clicked actions were performed");
    }
    public void addNewBooks(){
        clearFields(allBkAddTxt);
        showOnlyPanel("pnlBkAdd");
        allBkAddTxt[8].setText("-");    // txtBkAuth2
        allBkAddTxt[9].setText("-");    // txtBkAbout        
        lblBkErrSucc.setVisible(false);
    }
    public void removeBooks(){
        showOnlyPanel("pnlBkDel");
        lblBkD_errMsg.setText("  ");
    }
    public void editBookInfo(){
        showOnlyPanel("pnlBkEdit");
        txtBkEdit_find.setText("");
        lblBkEditErr.setVisible(false);
    }

}// Class Ended...
