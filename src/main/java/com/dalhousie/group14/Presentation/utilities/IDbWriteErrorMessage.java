package com.dalhousie.group14.Presentation.utilities;

public interface IDbWriteErrorMessage {
  static void displayMessage() {
    System.out.println("Couldn't perform the said operation due to there " +
        "being illegal information entered by you.");
  }
}
