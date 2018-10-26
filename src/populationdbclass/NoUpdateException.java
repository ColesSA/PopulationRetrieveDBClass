/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationdbclass;

import java.sql.SQLException;

/**
 *
 * @author 55colessa31
 */
public class NoUpdateException extends SQLException {
    NoUpdateException(String anException){
        super(anException);
    }
    
    NoUpdateException(Throwable cause){
        super(cause);
    }
    
    NoUpdateException(String message, Throwable cause){
        super(message, cause);
    }
}
