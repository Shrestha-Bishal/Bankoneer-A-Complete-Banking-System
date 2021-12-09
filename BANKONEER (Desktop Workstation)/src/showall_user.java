/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal
 */
public class showall_user {
    private int sno;
    private String branch, date,department, name, dob, father, mother, taddress, mno, email, citizenship, username, password ;
    private String title,gender,maritial,nationality,education,gfather,gmother,hw,paddress;
    private byte[] image,sign; 
    //constructor
    public showall_user(int sno, String branch, String date, String department,String title, String name,String gender,String maritial,String nationality, String dob,String education, String father,String mother,String gfather,String gmother,String hw,String paddress,String taddress,String mno, String email, String citizenship, String username, String password, byte[] image, byte[] sign){
             this.title=title;
             this.gender=gender;
                     this.maritial=maritial;
                     this.nationality=nationality;
                             this.education=education;
                             this.gfather=gfather;
                                     this.gmother=gmother;
                                     this.hw=hw;
                     
        this.sno= sno;
        this.branch=branch;
        this.date=date;
        this.department=department;
        this.name=name;
        this.dob=dob;
        this.father=father;
        this.mother=mother;
        this.taddress=taddress;
       // this.paddress=paddress;
        this.mno=mno;
        this.email=email;
        this.citizenship=citizenship; 
        this.username=username;
        this.password =password;
        this.image=image;
        this.sign=sign;
            }
                public String gettitle(){
        return title;
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
                    public String geteducation(){
        return education;
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
    public int getsno(){
        return sno;
    }    
        public String getbranch(){
        return branch;
    }
        public String getdate(){
        return date;
    }
                public String getdepartment(){
        return department;
    }
                        public String getname(){
        return name;
    }       
                        public String getdob(){
        return dob;
    }
            public String getfather(){
        return father;
    }        public String getmother(){
        return mother;
    }
        public String gettaddress(){
        return taddress;
    }
                        public String getmno(){
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
        public byte[] getimage(){
            return image;
        }
        public byte[] getsign(){
            return sign;
        }      
}
