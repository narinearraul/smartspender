//
//  ChoresHandler.h
//  WorkForIt
//
//  Created by Kevin Gu on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface ChoresHandler : NSObject
- (NSDictionary*) toDictionary :(NSString *)item_name withPrice:(NSString *)price;
- (NSDictionary*) toDictionary :(NSString *)item_name withPrice:(NSString *)price withStatus:(NSString *)status;
- (NSDictionary*) toDictionary :(NSArray *)array;
@end
