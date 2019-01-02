package com.dm.poc.fraud.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author bbalasub
 *
 */
public class Transaction implements Serializable {

	private static final long serialVersionUID = 6521684928844661096L;
	// Added in newly on Nov 14 2018
	/**
	 * OrgCode Seems to be a duplicate field in the incoming XML message. So,
	 * include only one field for that
	 */
	// Added by Rajesh
	private String Cur;
	private String OpRole;
	private String OpLoginId;
	private String RqDateTime;
	private boolean MustUnderstand;
	private String TranDate;
	private String TranTime;
	private BigDecimal Amt;
	private String MsgVersion;
	private String SvcVersion;
	private String RqClientOrg;
	private String RqClientCtry;

	private int OrgCode;
	private int CardPresent;
	private int ChannelId;
	private String ProdType;
	private String CardId;
	private String MainSuppInd;
	private String CardBrand;
	private int CardType;
	private String TranCtry;
	private long TranTimestamp;
	private String TranCur;
	private BigDecimal TranAmount;
	private String BillTranCur;
	private BigDecimal BillTranAmount;
	private int EntryMode;
	private boolean ECommerce;
	private String MerchantId;
	private int MerchantCat;
	private int ApprovalRef;
	private String TranStatus;
	private String TranStatusReason;
	private String TranStatusReasonDesc;
	private int Org;
	private long Acct;
	private int CardSeq;
	private int MerOrg;
	private int MerNbr;
	private int CreditPlan;
	private String RequestTypeId;
	private int CardTypeInd;
	private int Tc;
	private String InputSource;
	private long RefNbr;
	private String FinalAction;
	private String ForceFlag;
	private String PosInterfaceFlag;
	private String ProcessingLevel;
	private String ParameterLevelUsed;
	private String AvailCrv;
	private String CashAvailCrv;
	private String AcctCurrBalV;
	private String AcctCurrBalCashV;
	private String SourceTermId;
	private String SourceTransId;
	private String OprInitials;
	private String OprId;
	private String AuthorizorTermId;
	private String TimeSent;
	private long AbsTimeSent;
	private String TimeReceived;
	private String AbsTimeReceived;
	private int CallCreditId;
	private int SkuNbr;
	private String UnderMerFloorSw;
	private String SpclHandlingFileSw;
	private long GmtDateTime;
	private String AuthEmbossedName;
	private int ExpDate;
	private long AcqId;
	private long FwdId;
	private int CardExpiryDate;
	private int BlockCode1;
	private int BlockCode2;
	private String CreditLimit;
	private String TerminalId;
	private String CrdAccptNam;
	private String CrdAccptCity;
	private String CrdAccptStcry;
	private String OpenToBuy;
	private String VipStatus;
	private String CardAuthRslts;
	private int SvcCode;
	private int CardSeqNbr;
	private int RiskPoolId;
	private int BehScore;
	private int RiskScore;
	private String PosEnvirnmnt;
	private String Property;
	private String MktData;
	private int Duration;
	private String AmtSub;
	private long Data;
	private String StateCode;
	private String CountyCode;
	private int StipRtnCode;
	private String DeclRsnCd;
	private int CvvResult;
	private String Cvv2Result;
	private String PosCondCode;
	private String RqClientId;
	private String MsgUID;

	// Enriched fields
	private String CustInternalId;
	private String DocumentNumber;
	private String CardLogo;
	private String IndPrimaryCardHolder;

	public Transaction() {
		super();
	}

	public Transaction(long transactionNumber, long cardId, BigDecimal amount, String countryCode, String customerId,
			String targetAccountNo, String merchantCategoryCode, String merchantId, String cardBrand, int cardPresent,
			long timestamp, int riskScore) {
		super();
	}

	public String getCur() {
		return Cur;
	}

	public void setCur(String cur) {
		Cur = cur;
	}

	public String getOpRole() {
		return OpRole;
	}

	public void setOpRole(String opRole) {
		OpRole = opRole;
	}

	public String getOpLoginId() {
		return OpLoginId;
	}

	public void setOpLoginId(String opLoginId) {
		OpLoginId = opLoginId;
	}

	public String getRqDateTime() {
		return RqDateTime;
	}

	public void setRqDateTime(String rqDateTime) {
		RqDateTime = rqDateTime;
	}

	public boolean isMustUnderstand() {
		return MustUnderstand;
	}

	public void setMustUnderstand(boolean mustUnderstand) {
		this.MustUnderstand = mustUnderstand;
	}

	public String getTranDate() {
		return TranDate;
	}

	public void setTranDate(String tranDate) {
		TranDate = tranDate;
	}

	public String getTranTime() {
		return TranTime;
	}

	public void setTranTime(String tranTime) {
		TranTime = tranTime;
	}

	public BigDecimal getAmt() {
		return Amt;
	}

	public void setAmt(BigDecimal amt) {
		Amt = amt;
	}

	public String getMsgVersion() {
		return MsgVersion;
	}

	public void setMsgVersion(String msgVersion) {
		MsgVersion = msgVersion;
	}

	public String getSvcVersion() {
		return SvcVersion;
	}

	public void setSvcVersion(String svcVersion) {
		SvcVersion = svcVersion;
	}

	public String getRqClientOrg() {
		return RqClientOrg;
	}

	public void setRqClientOrg(String rqClientOrg) {
		RqClientOrg = rqClientOrg;
	}

	public String getRqClientCtry() {
		return RqClientCtry;
	}

	public void setRqClientCtry(String rqClientCtry) {
		RqClientCtry = rqClientCtry;
	}

	public String getCardId() {
		return CardId;
	}

	public void setCardId(String cardId) {
		this.CardId = cardId;
	}

	public String getMerchantId() {
		return MerchantId;
	}

	public void setMerchantId(String merchantId) {
		this.MerchantId = merchantId;
	}

	public String getCardBrand() {
		return CardBrand;
	}

	public void setCardBrand(String cardBrand) {
		this.CardBrand = cardBrand;
	}

	public int getRiskScore() {
		return RiskScore;
	}

	public void setRiskScore(int riskScore) {
		this.RiskScore = riskScore;
	}

	public int getChannelId() {
		return ChannelId;
	}

	public void setChannelId(int channelId) {
		ChannelId = channelId;
	}

	public String getProdType() {
		return ProdType;
	}

	public void setProdType(String prodType) {
		ProdType = prodType;
	}

	public String getMainSuppInd() {
		return MainSuppInd;
	}

	public void setMainSuppInd(String mainSuppInd) {
		MainSuppInd = mainSuppInd;
	}

	public int getOrgCode() {
		return OrgCode;
	}

	public void setOrgCode(int orgCode) {
		OrgCode = orgCode;
	}

	public int getCardType() {
		return CardType;
	}

	public void setCardType(int cardType) {
		CardType = cardType;
	}

	public String getTranCtry() {
		return TranCtry;
	}

	public void setTranCtry(String tranCtry) {
		TranCtry = tranCtry;
	}

	public long getTranTimestamp() {
		return TranTimestamp;
	}

	public void setTranTimestamp(long tranTimestamp) {
		TranTimestamp = tranTimestamp;
	}

	public String getTranCur() {
		return TranCur;
	}

	public void setTranCur(String tranCur) {
		TranCur = tranCur;
	}

	public BigDecimal getTranAmount() {
		return TranAmount;
	}

	public void setTranAmount(BigDecimal tranAmount) {
		TranAmount = tranAmount;
	}

	public String getBillTranCur() {
		return BillTranCur;
	}

	public void setBillTranCur(String billTranCur) {
		BillTranCur = billTranCur;
	}

	public BigDecimal getBillTranAmount() {
		return BillTranAmount;
	}

	public void setBillTranAmount(BigDecimal billTranAmount) {
		BillTranAmount = billTranAmount;
	}

	public int getEntryMode() {
		return EntryMode;
	}

	public void setEntryMode(int entryMode) {
		EntryMode = entryMode;
	}

	public boolean isECommerce() {
		return ECommerce;
	}

	public void setECommerce(boolean eCommerce) {
		ECommerce = eCommerce;
	}

	public int getMerchantCat() {
		return MerchantCat;
	}

	public void setMerchantCat(int merchantCat) {
		MerchantCat = merchantCat;
	}

	public int getApprovalRef() {
		return ApprovalRef;
	}

	public void setApprovalRef(int approvalRef) {
		ApprovalRef = approvalRef;
	}

	public String getTranStatus() {
		return TranStatus;
	}

	public void setTranStatus(String tranStatus) {
		TranStatus = tranStatus;
	}

	public String getTranStatusReason() {
		return TranStatusReason;
	}

	public void setTranStatusReason(String tranStatusReason) {
		TranStatusReason = tranStatusReason;
	}

	public String getTranStatusReasonDesc() {
		return TranStatusReasonDesc;
	}

	public void setTranStatusReasonDesc(String tranStatusReasonDesc) {
		TranStatusReasonDesc = tranStatusReasonDesc;
	}

	public int getOrg() {
		return Org;
	}

	public void setOrg(int org) {
		Org = org;
	}

	public long getAcct() {
		return Acct;
	}

	public void setAcct(long acct) {
		Acct = acct;
	}

	public int getCardSeq() {
		return CardSeq;
	}

	public void setCardSeq(int cardSeq) {
		CardSeq = cardSeq;
	}

	public int getMerOrg() {
		return MerOrg;
	}

	public void setMerOrg(int merOrg) {
		MerOrg = merOrg;
	}

	public int getMerNbr() {
		return MerNbr;
	}

	public void setMerNbr(int merNbr) {
		MerNbr = merNbr;
	}

	public int getCreditPlan() {
		return CreditPlan;
	}

	public void setCreditPlan(int creditPlan) {
		CreditPlan = creditPlan;
	}

	public String getRequestTypeId() {
		return RequestTypeId;
	}

	public void setRequestTypeId(String requestTypeId) {
		RequestTypeId = requestTypeId;
	}

	public int getCardTypeInd() {
		return CardTypeInd;
	}

	public void setCardTypeInd(int cardTypeInd) {
		CardTypeInd = cardTypeInd;
	}

	public int getTc() {
		return Tc;
	}

	public void setTc(int tc) {
		Tc = tc;
	}

	public String getInputSource() {
		return InputSource;
	}

	public void setInputSource(String inputSource) {
		InputSource = inputSource;
	}

	public long getRefNbr() {
		return RefNbr;
	}

	public void setRefNbr(long refNbr) {
		RefNbr = refNbr;
	}

	public String getFinalAction() {
		return FinalAction;
	}

	public void setFinalAction(String finalAction) {
		FinalAction = finalAction;
	}

	public String getForceFlag() {
		return ForceFlag;
	}

	public void setForceFlag(String forceFlag) {
		ForceFlag = forceFlag;
	}

	public String getPosInterfaceFlag() {
		return PosInterfaceFlag;
	}

	public void setPosInterfaceFlag(String posInterfaceFlag) {
		PosInterfaceFlag = posInterfaceFlag;
	}

	public String getProcessingLevel() {
		return ProcessingLevel;
	}

	public void setProcessingLevel(String processingLevel) {
		ProcessingLevel = processingLevel;
	}

	public String getParameterLevelUsed() {
		return ParameterLevelUsed;
	}

	public void setParameterLevelUsed(String parameterLevelUsed) {
		ParameterLevelUsed = parameterLevelUsed;
	}

	public String getAvailCrv() {
		return AvailCrv;
	}

	public void setAvailCrv(String availCrv) {
		AvailCrv = availCrv;
	}

	public String getCashAvailCrv() {
		return CashAvailCrv;
	}

	public void setCashAvailCrv(String cashAvailCrv) {
		CashAvailCrv = cashAvailCrv;
	}

	public String getAcctCurrBalV() {
		return AcctCurrBalV;
	}

	public void setAcctCurrBalV(String acctCurrBalV) {
		AcctCurrBalV = acctCurrBalV;
	}

	public String getAcctCurrBalCashV() {
		return AcctCurrBalCashV;
	}

	public void setAcctCurrBalCashV(String acctCurrBalCashV) {
		AcctCurrBalCashV = acctCurrBalCashV;
	}

	public String getSourceTermId() {
		return SourceTermId;
	}

	public void setSourceTermId(String sourceTermId) {
		SourceTermId = sourceTermId;
	}

	public String getSourceTransId() {
		return SourceTransId;
	}

	public void setSourceTransId(String sourceTransId) {
		SourceTransId = sourceTransId;
	}

	public String getOprInitials() {
		return OprInitials;
	}

	public void setOprInitials(String oprInitials) {
		OprInitials = oprInitials;
	}

	public String getOprId() {
		return OprId;
	}

	public void setOprId(String oprId) {
		OprId = oprId;
	}

	public String getAuthorizorTermId() {
		return AuthorizorTermId;
	}

	public void setAuthorizorTermId(String authorizorTermId) {
		AuthorizorTermId = authorizorTermId;
	}

	public String getTimeSent() {
		return TimeSent;
	}

	public void setTimeSent(String timeSent) {
		TimeSent = timeSent;
	}

	public long getAbsTimeSent() {
		return AbsTimeSent;
	}

	public void setAbsTimeSent(long absTimeSent) {
		AbsTimeSent = absTimeSent;
	}

	public String getTimeReceived() {
		return TimeReceived;
	}

	public void setTimeReceived(String timeReceived) {
		TimeReceived = timeReceived;
	}

	public String getAbsTimeReceived() {
		return AbsTimeReceived;
	}

	public void setAbsTimeReceived(String absTimeReceived) {
		AbsTimeReceived = absTimeReceived;
	}

	public int getCallCreditId() {
		return CallCreditId;
	}

	public void setCallCreditId(int callCreditId) {
		CallCreditId = callCreditId;
	}

	public int getSkuNbr() {
		return SkuNbr;
	}

	public void setSkuNbr(int skuNbr) {
		SkuNbr = skuNbr;
	}

	public String getUnderMerFloorSw() {
		return UnderMerFloorSw;
	}

	public void setUnderMerFloorSw(String underMerFloorSw) {
		UnderMerFloorSw = underMerFloorSw;
	}

	public String getSpclHandlingFileSw() {
		return SpclHandlingFileSw;
	}

	public void setSpclHandlingFileSw(String spclHandlingFileSw) {
		SpclHandlingFileSw = spclHandlingFileSw;
	}

	public long getGmtDateTime() {
		return GmtDateTime;
	}

	public void setGmtDateTime(long gmtDateTime) {
		GmtDateTime = gmtDateTime;
	}

	public String getAuthEmbossedName() {
		return AuthEmbossedName;
	}

	public void setAuthEmbossedName(String authEmbossedName) {
		AuthEmbossedName = authEmbossedName;
	}

	public int getExpDate() {
		return ExpDate;
	}

	public void setExpDate(int expDate) {
		ExpDate = expDate;
	}

	public long getAcqId() {
		return AcqId;
	}

	public void setAcqId(long acqId) {
		AcqId = acqId;
	}

	public long getFwdId() {
		return FwdId;
	}

	public void setFwdId(long fwdId) {
		FwdId = fwdId;
	}

	public int getCardExpiryDate() {
		return CardExpiryDate;
	}

	public void setCardExpiryDate(int cardExpiryDate) {
		CardExpiryDate = cardExpiryDate;
	}

	public int getBlockCode1() {
		return BlockCode1;
	}

	public void setBlockCode1(int blockCode1) {
		BlockCode1 = blockCode1;
	}

	public int getBlockCode2() {
		return BlockCode2;
	}

	public void setBlockCode2(int blockCode2) {
		BlockCode2 = blockCode2;
	}

	public String getCreditLimit() {
		return CreditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		CreditLimit = creditLimit;
	}

	public String getTerminalId() {
		return TerminalId;
	}

	public void setTerminalId(String terminalId) {
		TerminalId = terminalId;
	}

	public String getCrdAccptNam() {
		return CrdAccptNam;
	}

	public void setCrdAccptNam(String crdAccptNam) {
		CrdAccptNam = crdAccptNam;
	}

	public String getCrdAccptCity() {
		return CrdAccptCity;
	}

	public void setCrdAccptCity(String crdAccptCity) {
		CrdAccptCity = crdAccptCity;
	}

	public String getCrdAccptStcry() {
		return CrdAccptStcry;
	}

	public void setCrdAccptStcry(String crdAccptStcry) {
		CrdAccptStcry = crdAccptStcry;
	}

	public String getOpenToBuy() {
		return OpenToBuy;
	}

	public void setOpenToBuy(String openToBuy) {
		OpenToBuy = openToBuy;
	}

	public String getVipStatus() {
		return VipStatus;
	}

	public void setVipStatus(String vipStatus) {
		VipStatus = vipStatus;
	}

	public String getCardAuthRslts() {
		return CardAuthRslts;
	}

	public void setCardAuthRslts(String cardAuthRslts) {
		CardAuthRslts = cardAuthRslts;
	}

	public int getSvcCode() {
		return SvcCode;
	}

	public void setSvcCode(int svcCode) {
		SvcCode = svcCode;
	}

	public int getCardSeqNbr() {
		return CardSeqNbr;
	}

	public void setCardSeqNbr(int cardSeqNbr) {
		CardSeqNbr = cardSeqNbr;
	}

	public int getRiskPoolId() {
		return RiskPoolId;
	}

	public void setRiskPoolId(int riskPoolId) {
		RiskPoolId = riskPoolId;
	}

	public int getBehScore() {
		return BehScore;
	}

	public void setBehScore(int behScore) {
		BehScore = behScore;
	}

	public String getPosEnvirnmnt() {
		return PosEnvirnmnt;
	}

	public void setPosEnvirnmnt(String posEnvirnmnt) {
		PosEnvirnmnt = posEnvirnmnt;
	}

	public String getProperty() {
		return Property;
	}

	public void setProperty(String property) {
		Property = property;
	}

	public String getMktData() {
		return MktData;
	}

	public void setMktData(String mktData) {
		MktData = mktData;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public String getAmtSub() {
		return AmtSub;
	}

	public void setAmtSub(String amtSub) {
		AmtSub = amtSub;
	}

	public long getData() {
		return Data;
	}

	public void setData(long data) {
		Data = data;
	}

	public String getStateCode() {
		return StateCode;
	}

	public void setStateCode(String stateCode) {
		StateCode = stateCode;
	}

	public String getCountyCode() {
		return CountyCode;
	}

	public void setCountyCode(String countyCode) {
		CountyCode = countyCode;
	}

	public int getStipRtnCode() {
		return StipRtnCode;
	}

	public void setStipRtnCode(int stipRtnCode) {
		StipRtnCode = stipRtnCode;
	}

	public String getDeclRsnCd() {
		return DeclRsnCd;
	}

	public void setDeclRsnCd(String declRsnCd) {
		DeclRsnCd = declRsnCd;
	}

	public int getCvvResult() {
		return CvvResult;
	}

	public void setCvvResult(int cvvResult) {
		CvvResult = cvvResult;
	}

	public String getCvv2Result() {
		return Cvv2Result;
	}

	public void setCvv2Result(String cvv2Result) {
		Cvv2Result = cvv2Result;
	}

	public String getPosCondCode() {
		return PosCondCode;
	}

	public void setPosCondCode(String posCondCode) {
		PosCondCode = posCondCode;
	}

	public String getCustInternalId() {
		return CustInternalId;
	}

	public void setCustInternalId(String custInternalId) {
		CustInternalId = custInternalId;
	}

	public String getDocumentNumber() {
		return DocumentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		DocumentNumber = documentNumber;
	}

	public String getCardLogo() {
		return CardLogo;
	}

	public void setCardLogo(String cardLogo) {
		CardLogo = cardLogo;
	}

	public String getIndPrimaryCardHolder() {
		return IndPrimaryCardHolder;
	}

	public void setIndPrimaryCardHolder(String indPrimaryCardHolder) {
		IndPrimaryCardHolder = indPrimaryCardHolder;
	}

	public String getRqClientId() {
		return RqClientId;
	}

	public void setRqClientId(String rqClientId) {
		RqClientId = rqClientId;
	}

	public String getMsgUID() {
		return MsgUID;
	}

	public void setMsgUID(String msgUID) {
		MsgUID = msgUID;
	}

	public int getCardPresent() {
		return CardPresent;
	}

	public void setCardPresent(int cardPresent) {
		CardPresent = cardPresent;
	}

	@Override
	public String toString() {
		return "Transaction [Cur=" + Cur + ", OpRole=" + OpRole + ", OpLoginId=" + OpLoginId + ", RqDateTime="
				+ RqDateTime + ", MustUnderstand=" + MustUnderstand + ", TranDate=" + TranDate + ", TranTime="
				+ TranTime + ", Amt=" + Amt + ", MsgVersion=" + MsgVersion + ", SvcVersion=" + SvcVersion
				+ ", RqClientOrg=" + RqClientOrg + ", RqClientCtry=" + RqClientCtry + ", OrgCode=" + OrgCode
				+ ", CardPresent=" + CardPresent + ", ChannelId=" + ChannelId + ", ProdType=" + ProdType + ", CardId="
				+ CardId + ", MainSuppInd=" + MainSuppInd + ", CardBrand=" + CardBrand + ", CardType=" + CardType
				+ ", TranCtry=" + TranCtry + ", TranTimestamp=" + TranTimestamp + ", TranCur=" + TranCur
				+ ", TranAmount=" + TranAmount + ", BillTranCur=" + BillTranCur + ", BillTranAmount=" + BillTranAmount
				+ ", EntryMode=" + EntryMode + ", ECommerce=" + ECommerce + ", MerchantId=" + MerchantId
				+ ", MerchantCat=" + MerchantCat + ", ApprovalRef=" + ApprovalRef + ", TranStatus=" + TranStatus
				+ ", TranStatusReason=" + TranStatusReason + ", TranStatusReasonDesc=" + TranStatusReasonDesc + ", Org="
				+ Org + ", Acct=" + Acct + ", CardSeq=" + CardSeq + ", MerOrg=" + MerOrg + ", MerNbr=" + MerNbr
				+ ", CreditPlan=" + CreditPlan + ", RequestTypeId=" + RequestTypeId + ", CardTypeInd=" + CardTypeInd
				+ ", Tc=" + Tc + ", InputSource=" + InputSource + ", RefNbr=" + RefNbr + ", FinalAction=" + FinalAction
				+ ", ForceFlag=" + ForceFlag + ", PosInterfaceFlag=" + PosInterfaceFlag + ", ProcessingLevel="
				+ ProcessingLevel + ", ParameterLevelUsed=" + ParameterLevelUsed + ", AvailCrv=" + AvailCrv
				+ ", CashAvailCrv=" + CashAvailCrv + ", AcctCurrBalV=" + AcctCurrBalV + ", AcctCurrBalCashV="
				+ AcctCurrBalCashV + ", SourceTermId=" + SourceTermId + ", SourceTransId=" + SourceTransId
				+ ", OprInitials=" + OprInitials + ", OprId=" + OprId + ", AuthorizorTermId=" + AuthorizorTermId
				+ ", TimeSent=" + TimeSent + ", AbsTimeSent=" + AbsTimeSent + ", TimeReceived=" + TimeReceived
				+ ", AbsTimeReceived=" + AbsTimeReceived + ", CallCreditId=" + CallCreditId + ", SkuNbr=" + SkuNbr
				+ ", UnderMerFloorSw=" + UnderMerFloorSw + ", SpclHandlingFileSw=" + SpclHandlingFileSw
				+ ", GmtDateTime=" + GmtDateTime + ", AuthEmbossedName=" + AuthEmbossedName + ", ExpDate=" + ExpDate
				+ ", AcqId=" + AcqId + ", FwdId=" + FwdId + ", CardExpiryDate=" + CardExpiryDate + ", BlockCode1="
				+ BlockCode1 + ", BlockCode2=" + BlockCode2 + ", CreditLimit=" + CreditLimit + ", TerminalId="
				+ TerminalId + ", CrdAccptNam=" + CrdAccptNam + ", CrdAccptCity=" + CrdAccptCity + ", CrdAccptStcry="
				+ CrdAccptStcry + ", OpenToBuy=" + OpenToBuy + ", VipStatus=" + VipStatus + ", CardAuthRslts="
				+ CardAuthRslts + ", SvcCode=" + SvcCode + ", CardSeqNbr=" + CardSeqNbr + ", RiskPoolId=" + RiskPoolId
				+ ", BehScore=" + BehScore + ", RiskScore=" + RiskScore + ", PosEnvirnmnt=" + PosEnvirnmnt
				+ ", Property=" + Property + ", MktData=" + MktData + ", Duration=" + Duration + ", AmtSub=" + AmtSub
				+ ", Data=" + Data + ", StateCode=" + StateCode + ", CountyCode=" + CountyCode + ", StipRtnCode="
				+ StipRtnCode + ", DeclRsnCd=" + DeclRsnCd + ", CvvResult=" + CvvResult + ", Cvv2Result=" + Cvv2Result
				+ ", PosCondCode=" + PosCondCode + ", RqClientId=" + RqClientId + ", MsgUID=" + MsgUID
				+ ", CustInternalId=" + CustInternalId + ", DocumentNumber=" + DocumentNumber + ", CardLogo=" + CardLogo
				+ ", IndPrimaryCardHolder=" + IndPrimaryCardHolder + "]";
	}
}
