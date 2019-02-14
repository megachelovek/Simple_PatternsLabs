package com.ssau;

import java.io.FileWriter;
import java.io.IOException;

public class ChainResponsibilityColumn implements ChainResponsibility{
    @Override
    public void OutputStudent(Pupil pupil) {
        if (pupil.getLength() >3){
            try(FileWriter writer = new FileWriter("TextChainResponsibility.txt", false))
            {
                String text = "";
                for (String subj: pupil.getSubjects()) {
                    text += subj +"\n";
                }
                writer.write(text);
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            this.GetNextMember(pupil);
        }
    }

    @Override
    public void GetNextMember(Pupil pupil) {
        ChainResponsibilityString chainResponsibilityString = new ChainResponsibilityString();
        chainResponsibilityString.OutputStudent(pupil);
    }
}