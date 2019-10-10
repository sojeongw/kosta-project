package project.model;

import java.util.List;

public interface RoomDAO {

   public int insert(RoomVO vo);

   public int update(RoomVO vo);

   public int delete(int num);

   public List<RoomVO> selectAll();
   
   public RoomVO selectOne(RoomVO vo);
   

}