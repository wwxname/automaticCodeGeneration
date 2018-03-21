package com.td.spm.generator;

//import com.td.spm.entity.FpmDict;
//import com.td.spm.entity.FpmFace;
//import com.td.spm.entity.HouseBasicInfo;
//import com.td.spm.entity.LiveWithPeople;
//import com.td.spm.entity.ProblemFeedback;
//import com.td.spm.entity.RentalApply;
//import com.td.spm.entity.RepairApply;
//import com.td.spm.entity.RoomBasicInfo;
//
//import com.td.spm.entity.UserInfo;
//import com.td.spm.entity.Village;
//import com.td.spm.entity.Zone;
import com.td.spm.entity.UserAndHouseRoom;
import com.td.spm.entity.UserinfoBackup;
import com.td.spm.entity.VillageAndDevice;
import com.td.spm.entity.alarm.AlarmType;
import com.td.spm.entity.auth.TrustInfo;
import com.td.spm.entity.auth.TrustSet;
import com.td.spm.entity.fpm.AccessRecord;
import com.td.spm.entity.fpm.CaptureData;
import com.td.spm.entity.inoutentity.CarCharg;
import com.td.spm.entity.merge.PersonMerge;
import com.td.spm.entity.patrol.GroupAndUser;
import com.td.spm.entity.patrol.PatrolGroup;
import com.td.spm.entity.patrol.PatrolPlan;
import com.td.spm.entity.patrol.PatrolRoute;
import com.td.spm.entity.patrol.PointRecord;
import com.td.spm.entity.patrol.RountRecord;
import com.td.spm.entity.patrol.RouteAndDevice;
import com.td.spm.entity.personSimilar.SimiKuaidi;
import com.td.spm.entity.personSimilar.SimiWaimai;

//import com.td.spm.entity.Student;


public class JavaGeneratorClient { 	  	
 
   
	public static void main(String[] args)  {		
		SimiWaimai sd = new SimiWaimai();
		sd.setCode("wwx");
		FreeMarkerUtil.createJavaFile(sd);
		
	}
	

}
