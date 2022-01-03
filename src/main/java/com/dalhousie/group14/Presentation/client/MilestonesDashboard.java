package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.BusinessLogic.client.IMilestones;
import com.dalhousie.group14.BusinessLogic.client.Milestones;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;

import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: ClientProject.java
 * @ClassDescription: This class is used for the purpose of providing
 * the screen for milestones definition.
 */
public class MilestonesDashboard implements IMilestonesDashboard {
    public static final int MAX_TRIES = 5;
    public static final int MILESTONE_LIMIT = 3;


    public Map<Date,String> definemilestonescreen(Date start_date, Date end_date) {
        boolean m1 = false;
        int mcount = 1;
        int tries = 0;
        Map<Date, String> received = new HashMap<>();
        IMilestones obj = new Milestones();

        while (mcount != MILESTONE_LIMIT || tries != MAX_TRIES) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Enter the " + Validations.noreturn(mcount) + " Milestone's Description : ");
            String milestone_desc = sc.nextLine();
            System.out.print("Enter the " + Validations.noreturn(mcount) + " Milestone's Deadline Date : ");
            String milestone1_date = sc.nextLine();
            Date milestone_date = Validations.datesetter(milestone1_date);
            if (milestone_date != null) {
                received = obj.definemilestones(mcount, start_date, end_date, milestone_date, milestone_desc);
                if (received != null) {
                    mcount++;
                }
            }
            tries++;
            if (tries == MAX_TRIES) {
                System.out.println("Maximum Input Tries Limit Reached, Program will exit.");
            }
            if (mcount > MILESTONE_LIMIT) {
                return received;

            }
        }
        return null;
    }

}

