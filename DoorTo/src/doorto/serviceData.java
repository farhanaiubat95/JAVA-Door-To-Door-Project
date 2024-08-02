/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doorto;

import java.sql.Date;

public class serviceData {
    private Integer sid;
    private String sname;
    private String roomsz;
    private Double price;
    private String area;
    private String image;
    private Date date;
    
    
    public serviceData(Integer sid,String sname,String roomsz, Double price,String area,String image,Date date ){
        this.sid=sid;
        this.sname=sname;
        this.roomsz=roomsz;
        this.price=price;
        this.area=area;    
        this.image=image;
        this.date=date;
    }
    
    public Integer getSid(){
        return sid;
     }
    
     public String getSname(){
        return sname;
     }
     
     public String getRoomsz(){
        return roomsz;
     }
     
      public Double getPrice(){
        return price;
     }
     
     public String getArea(){
        return area;
     }
     
     public String getImage(){   
        return image;   
     }
     
       public Date getDate(){
        return date;
     }
    
}
