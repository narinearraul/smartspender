//
//  TableViewCell.h
//  WorkForIt
//
//  Created by Nitesh on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface TableViewCell : UITableViewCell

@property(weak,nonatomic) IBOutlet UILabel *chore;
@property(weak,nonatomic) IBOutlet UILabel *earned;


@end
