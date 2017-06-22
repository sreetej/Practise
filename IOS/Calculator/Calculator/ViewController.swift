//
//  ViewController.swift
//  Calculator
//
//  Created by SreeTej on 22/06/17.
//  Copyright © 2017 SreeTej. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var display: UILabel!
    
    var useInTheMiddleOfTyping = false
    
    @IBAction func touchDigit(sender: UIButton) {
        
        let digit = sender.currentTitle!
        
        if useInTheMiddleOfTyping{
             let textCurrentlyInDisplay = display.text!
             display.text = textCurrentlyInDisplay + digit
        }else
        {
            display.text = digit
        }
        
        useInTheMiddleOfTyping = true
    }
    
    
    @IBAction func performOperation(sender: UIButton) {
        if let mathematicalSymbol = sender.currentTitle
        {
            if mathematicalSymbol == "π"{
            display.text = String(M_PI)
            }
        }
    }
    
}

