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
//import com.td.spm.entity.Village;
//import com.td.spm.entity.fpm.SysNotice;
import com.td.spm.entity.UserInfo;
import com.td.spm.entity.VillageAndDevice;
import com.td.spm.entity.auth.TrustInfo;
import com.td.spm.entity.auth.TrustSet;
import com.td.spm.entity.fpm.AccessRecord;
import com.td.spm.entity.patrol.PatrolPlan;
import com.td.spm.entity.patrol.PatrolRoute;
import com.td.spm.entity.patrol.PointRecord;
import com.td.spm.entity.patrol.RountRecord;

//import com.td.spm.entity.SpmDict;


public class MapperGeneratorClient {

	public static void main(String[] args)  {		

		//SpmDict  sd = new SpmDict();
		//sd.setCode("wwx");
		
		PatrolRoute  sd = new PatrolRoute();
		sd.setCode("wwx");
		FreeMarkerUtil.createMapperFile(sd);
		
		
	}
	
}
