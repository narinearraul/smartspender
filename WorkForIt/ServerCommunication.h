//
//  ServerCommunication.h
//  WorkForIt
//
//  Created by Kevin Gu on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import <Foundation/Foundation.h>

static NSString* const IPADDRESS=@"http://137.110.91.155:3000/";
static NSString* const CHILD=@"child";
static NSString* const PERSON=@"person";
static NSString* const ADD_ITEM=@"api/child/addItem";
static NSString* const CHILD_GET_CHORES=@"api/child/getChores";
static NSString* const CHECK_OFF=@"api/child/checkOffChores";
static NSString* const GET_BALANCE=@"api/child/getBalance";
static NSString* const GET_ITEM=@"api/parent/getItem";
static NSString* const SET_CHORES=@"api/parent/setChores";
static NSString* const PARENT_GET_CHORES=@"api/parent/getChores";
static NSString* const GET_CHECKED_OFF_CHORES=@"api/parent/getCheckedOffChores";
static NSString* const APPROVE_CHECKED_OFF=@"api/parent/approveCheckedOffChores";


@interface ServerCommunication : NSObject

-(void) sendToServer: (NSString*) urlString withJSON:(NSDictionary*) json;

-(void) getJsonFromServer:(NSString *) urlString withBlock: (void(^)(id))block;

-(void)sendChoresToServer:(NSString*) urlString withArray:(NSArray*) array;
//get this json object only when get chores is added
-(NSDictionary*) getJson;
@end
