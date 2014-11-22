//
//  ChoresHandler.m
//  WorkForIt
//
//  Created by Kevin Gu on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import "ChoresHandler.h"

@implementation ChoresHandler

#define safeSet(d,k,v) if (v) d[k] = v;
//child wish item
- (NSDictionary*) toDictionary :(NSString *)item_name withPrice:(NSString *)price
{
    NSMutableDictionary* jsonable = [NSMutableDictionary dictionary];
    safeSet(jsonable, @"itemName",item_name);
    safeSet(jsonable, @"price", price)
    return jsonable;
}

//child check off chore
- (NSDictionary*) toDictionary :(NSString *)item_name withPrice:(NSString *)price withStatus:(NSString *)status
{
    NSMutableDictionary* jsonable = [NSMutableDictionary dictionary];
    safeSet(jsonable, @"itemName",item_name);
    safeSet(jsonable, @"price", price)
    safeSet(jsonable, @"status", status)
    return jsonable;
}
- (NSDictionary*) toDictionary :(NSArray *)array
{
    NSMutableDictionary* jsonable = [NSMutableDictionary dictionary];
    safeSet(jsonable, @"array",array);
    return jsonable;
}
//child check off chore

@end
