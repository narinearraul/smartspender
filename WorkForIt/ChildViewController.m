//
//  ChildViewController.m
//  WorkForIt
//
//  Created by Nitesh on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import "ChildViewController.h"
#import "ChoresHandler.h"
#import "ServerCommunication.h"

@interface ChildViewController ()

@end

@implementation ChildViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    ChoresHandler* handler=[[ChoresHandler alloc]init];
    //Children
    //sending off wish item
    NSDictionary* dict=[handler toDictionary:@"test123" withPrice:@"114215"];
    ServerCommunication* server=[[ServerCommunication alloc]init];
    /*NSLog(@"%@",[IPADDRESS stringByAppendingString: ADD_ITEM]);
    [server sendToServer:[IPADDRESS stringByAppendingString: ADD_ITEM] withJSON:dict];
    */
    //sending check off
    /*NSMutableArray * arr = [[NSMutableArray alloc] init];
    [arr addObject:[handler toDictionary:@"choretest1" withPrice:@"12" withStatus:@"COMPLETE"]];
    [arr addObject: [handler toDictionary:@"chorestest2" withPrice:@"13" withStatus:@"COMPLETE"]];
    
    [server sendChoresToServer:[IPADDRESS stringByAppendingString: CHECK_OFF] withArray:arr];
    */
    /*
     //get Chores
     [server getJsonFromServer:[IPADDRESS stringByAppendingString: CHILDREN_GET_CHORES] withBlock:^(id sender) {
        NSLog(@"%@",[server getJson]);
    }];
     
    
    NSLog(@"%@",[IPADDRESS stringByAppendingString: GET_BALANCE]);
    [server getJsonFromServer:[IPADDRESS stringByAppendingString: GET_BALANCE] withBlock:^(id sender) {
        NSLog(@"balance: %@",[server getJson]);
    }];*/
    
    
    //PARENT
    /*[server getJsonFromServer:[IPADDRESS stringByAppendingString: GET_ITEM] withBlock:^(id sender){
        NSLog(@"parent get item: %@",[server getJson]);
    }];*/
    // Do any additional setup after loading the view.
    
    //Set Chores
    NSMutableArray * arr = [[NSMutableArray alloc] init];
    [arr addObject:[handler toDictionary:@"choretest1" withPrice:@"12" withStatus:@"INCOMPLETE"]];
    [arr addObject: [handler toDictionary:@"chorestest2" withPrice:@"13" withStatus:@"INCOMPLETE"]];
    [server sendChoresToServer:[IPADDRESS stringByAppendingString: SET_CHORES] withArray:arr];
    
    //GetChores
    [server getJsonFromServer:[IPADDRESS stringByAppendingString: PARENT_GET_CHORES] withBlock:^(id sender){
        NSLog(@"parent get chores: %@",[server getJson]);
    }];
    
    //Children checked off chore
    [server getJsonFromServer:[IPADDRESS stringByAppendingString: GET_CHECKED_OFF_CHORES] withBlock:^(id sender){
        NSLog(@"parent get checked chores: %@",[server getJson]);
    }];
    
    //approve Check OFF
    [server sendChoresToServer:[IPADDRESS stringByAppendingString: APPROVE_CHECKED_OFF] withArray:arr];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
