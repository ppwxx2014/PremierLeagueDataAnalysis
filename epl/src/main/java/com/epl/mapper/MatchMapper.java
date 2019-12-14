package com.epl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.epl.vo.InGamePosition;
import com.epl.vo.MatchCheckKeeper;
import com.epl.vo.MatchGoalKeeper;
import com.epl.vo.MatchGoals;
import com.epl.vo.MatchNoTeamName;
import com.epl.vo.MatchOwnGoals;
import com.epl.vo.MatchPlayer;
import com.epl.vo.MatchPlayerNo;
import com.epl.vo.MatchRefree;
import com.epl.vo.MatchResult;
import com.epl.vo.MatchSchedule;
import com.epl.vo.Player;
import com.epl.vo.PlayerInfo;
import com.epl.vo.Refree;
import com.epl.vo.Team;
import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

@Mapper
public interface MatchMapper {
	
	//홈팀의 이름으로 해당팀의 홈구장을 가져온다.
	public String selectStadiumByTeamName(String teamName);

	//새로운 경기 일정을 입력한다.
	public int insertMatch(MatchSchedule matchSchedule);

	//경기의 심판을 입력한다
	public int insertMatchRefree(MatchRefree matchRefree);

	//시작하지않았거나 진행중인 경기의 리스트를 가져온다
	public List<MatchSchedule> selectMatchList();

	//한경기의 정보를 가져온다
	public MatchSchedule selectMatchOne(int matchNo);
	
	//playerMatch 테이블에 정해놓은 선발중 골키퍼를 제외한 양팀의 선수 20명의 기본데이터를 입력한다
	public int insertMainPlayer(MatchPlayerNo MatchPlayerNo);
	
	//playerMatch 테이블에 정해놓은 양팀의 후보선수 14명의 기본데이터를 입력한다
	public int insertSubPlayer(MatchPlayerNo MatchPlayerNo);
	
	//playerMatch 테이블에 정해놓은 선발 골키퍼 2명의 기본데이터를 입력한다
	public int insertKeeper(MatchPlayerNo MatchPlayerNo);
	
	//한선수가 한경기에서 키퍼로 선정되어있는지를 검사한다
	public MatchCheckKeeper selectKeeperInMatch(MatchCheckKeeper  matchCheckKeeper);
	
	//한선수의 경기정보를 가져온다 (선발 선수의 startTime을 가져오기 위해 사용)
	public MatchPlayer selectmatchPlayerOne(MatchPlayer matchPlayer);
	
	//한키퍼의 경기정보를 가져온다(선발 키퍼의 startTime을 가져오기 위해 사용)
	public MatchGoalKeeper selectMatchGoalKeeperOne(MatchGoalKeeper matchGoalKeeper);
	
	//경기가 끝날시 선수기록을 업데이트한다(active : F)
	public int updateMatchPlayer(MatchPlayer matchPlayer);
	
	//선수교체시 새로운선수의 startTime을 바꾸기위해 사용한다(active : T)
	public int updateMatchPlayerT(MatchPlayer matchPlayer);
	
	//골을 넣을시 matchGoals테이블에 골의 정보를 입력한다
	public int insertMatchGoals(MatchGoals matchGoals);
	
	//자책골을 넣을시 matchGoals테이블에 자책골의 정보를 입력한다
	public int insertMatchOwnGoals(MatchOwnGoals matchOwnGoals);
	
	//경기일정 생성시 실시간 테이블을 함께 만든다
	public int insertMatchResult(MatchResult matchResult);
	
	//골을 넣은후 결과 테이블의 점수를 업데이트하기위해 사용한다
	public int updateMatchResultByGoal(MatchGoals matchGoals);
	
	//자책골을 넣은후 결과테이블의 점수를 업데이트하기위해 사용한다
	public int updateMatchResultByOwnGoal(MatchOwnGoals matchOwnGoals);
	
	//골키퍼의 기록을 업데이트한다(active : F)
	public int updateMatchKeeper(MatchGoalKeeper matchGoalKeeper);
	
	//선수 교체시 출전한 선수의 startTime을 현재시간으로 업데이트하는 매서드
	public int updateMatchKeeperT(MatchGoalKeeper matchGoalKeeper);
	
	//게임내의 포지션이 선발일 선수들의 리스트를 가져온다
	public List<InGamePosition> selectMainAndKeeper(MatchNoTeamName matchNoTeamName);
	
	//현재 이경기에 이 팀의 골키퍼의 activ가 T인지확인한다
	public InGamePosition selectMatchKeeperT(MatchNoTeamName matchNoTeamName);
	
	//선택한팀의 모든 선수리스트를 가져온다
	public List<PlayerInfo> selectPlayerListByTeamName(String teamName);
	
	//선택한경기에서 선택한 팀의 선수들을 해당 경기내의 포지션과 함께 가져온다
	public List<InGamePosition> selectCommutablePlayer(MatchNoTeamName matchNoTeamName);
	
	//후보선수가 골키퍼와 교체될때 matchPlayer테이블의 행을 지운다
	public int deleteMatchPlayer(MatchPlayer matchPlayer);
	
	//이경기 우리팀의 최근 퇴장당한 골키퍼퍼의 퇴장 시간을 가져온다
	public InGamePosition selectLatelyEndTimeOfKeeper(MatchNoTeamName matchNoTeamName);
}
