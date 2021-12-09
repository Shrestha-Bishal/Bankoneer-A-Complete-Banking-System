/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal
 */
class Employee {
   private int sno, mno;
   private String branch,title,name,gender,maritial,nationality,education,father,mother,gfather,gmother,hw,paddress,taddress;
   private String email,citizenship,username,password,department;
   private String date,dobbs,dobad;
   private byte[] image,signature;    
   //constructor
   public Employee(int sno,String date,String branch,String title,String name,String gender,String maritial,String nationality,String dobbs,String dobad,String education,String father,String mother,String gfather,String gmother,String hw,String paddress,String taddress,int mno,String email,String citizenship,String username,String password,String department,byte[] image,byte[] signature)
   {
     this.sno=sno;  
     this.branch=branch;
               this.date=date;
               this.title=title;
                this.name=name;
                     this.gender=gender;
                          this.maritial=maritial;
                             this.nationality=nationality;
                                 this.dobbs=dobbs;
                                    this.dobad=dobad;
                                     this.education=education;
                                         this.father=father;
                                            this.mother=mother;
                                                 this.gfather=gfather;
                                                  this.gmother=gmother;
                                                        this.hw=hw;
                                                           this.paddress=paddress;
                                                          this.taddress=taddress;
                                                                  this.mno=mno;
                                                                  this.email=email;
                                                                          this.citizenship=citizenship;
                                                                          this.username=username;
                                                                             this.password=password;
                                                                                this.department=department;
                                                                                      this.image=image;
                                                                                        this.signature=signature;
               
   }

   public int getsno(){
    return sno;
}
   public String getbranch(){
      return branch;
   }     
   public String getdate(){
      return date;
   }
   public String gettitle(){
      return title;
   }
   public String getname(){
      return name;
   }     
   public String getgender(){
      return gender;
   }
   public String getmaritial(){
      return maritial;
   }
   public String getnationality(){
      return nationality;
   }
   public String getdobbs(){
      return dobbs;
   }
   public String getdobad(){
      return dobad;
   }
   public String geteducation(){
      return education;
   }    
   public String getfather(){
      return father;
   }
   public String getmother(){
      return mother;
   }
   public String getgfather(){
      return gfather;
   }
   public String getgmother(){
      return gmother;
   }
   public String gethw(){
      return hw;
   }
   public String getpaddress(){
      return paddress;
   }
   public String gettaddress(){
      return taddress;
   }
   public int getmno(){
      return mno;
   }
 
   public String getemail(){
      return email;
   }
   public String getcitizenship(){
      return citizenship;
   }   
   public String getusername(){
      return username;
   }
   public String getpassword(){
      return password;
   }
   
     public String getdepartment(){
      return department;
   }
      public byte[] getimage(){
      return image;
   }
      public byte[] getsignature(){
      return signature;
   }
    
}
