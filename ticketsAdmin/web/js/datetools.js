
  /**
   * Vefifica si el anno que se pasa es bisciesto
   * @param {int} year Anno a ser verificado
   * @returns {Boolean} Si es biscieto o no
   */
  function isLeapYear( year ) { 
    
    if (( year % 4 ) === 0 )
       if ((( year % 100) !== 0 ) || (( year % 400 ) === 0 ))
          if (( year % 400 ) !== 0 )
             return true;       
    return false;   
  }

  /**
   * Valida si la fecha es correcta en 2 aspectos: que tenga el formato adecuado
   * y que los datos sean logicos
   * @param {type} theDate
   * @returns {Number}
   */
  function isValidDate( theDate ) {
    
    // verificamos el formato
    if ( !theDate.match(/^[0-9]{4}\-[0-9]{2}\-[0-9]{2}$/)) 
       return -1;
        
    var baseYear = 2017;   
    var year     = parseInt( theDate.substr( 0, 4 ), 10 );
    var mon      = parseInt( theDate.substr( 5, 2 ), 10 );
    var day      = parseInt( theDate.substr( 8, 2 ), 10 );
    
    var maxDay = 31;    
    if (  mon === 4 || mon === 6 || mon === 9 || mon === 11 )
       maxDay = 30;
    else if ( mon === 2 ) 
       maxDay = ( isLeapYear( year )) ? 29 : 28;

    if ( year < baseYear || ( mon < 1 || mon > 12 ) || ( day < 1 || day > maxDay ))
       return -2;
    return 0;
  }
