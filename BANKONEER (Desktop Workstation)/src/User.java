/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal
 */
class User {
    private int sno;
    private String branch, date,department, name, dob, father, mother, taddress, mno, email, citizenship, username, password ;
    private byte[] image,sign,citizenshipimage; 
    //constructor
    public User(int sno, String branch, String date, String department, String name,String dob,String father,String mother, String taddress,String mno, String email, String citizenship, String username, String password, byte[] image, byte[] sign){
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
        this.citizenshipimage=citizenshipimage;
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
                public byte[] getcitizenshipimage(){
            return citizenshipimage;
        }
}
